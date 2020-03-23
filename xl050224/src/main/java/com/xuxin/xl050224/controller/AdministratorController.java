package com.xuxin.xl050224.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.constant.ClientExceptionConstant;
import com.xuxin.xl050224.dto.in.*;
import com.xuxin.xl050224.dto.out.AdministratorGetProfileOutDTO;
import com.xuxin.xl050224.dto.out.AdministratorLoginOutDTO;
import com.xuxin.xl050224.dto.out.AdministratorShowOutDTO;
import com.xuxin.xl050224.entity.Administrator;
import com.xuxin.xl050224.enumeration.AdministratorStatus;
import com.xuxin.xl050224.exception.ClientException;
import com.xuxin.xl050224.service.AdministratorService;
import com.xuxin.xl050224.utils.EmailUtil;
import com.xuxin.xl050224.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private SecureRandom secureRandom;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Autowired
    private EmailUtil emailUtil;

    private Map<String, String> emailPwdResetCodeMap = new HashMap<>();

    //登录
    @GetMapping("/login")
    public AdministratorLoginOutDTO login( AdministratorLoginInDTO administratorLoginInDTO) throws ClientException {
        Administrator byUsername = administratorService.getByUsername(administratorLoginInDTO.getUsername());
        if (byUsername == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE,ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encryptedPassword = byUsername.getEncryptedPassword();
         BCrypt.Result verify = BCrypt.verifyer().verify(administratorLoginInDTO.getPassword().toCharArray(), encryptedPassword);
        if (verify.verified){
            AdministratorLoginOutDTO administratorLoginOutDTO = jwtUtil.issueToken(byUsername);
            return administratorLoginOutDTO;
        }else{
            throw new ClientException(ClientExceptionConstant.TOKEN_INVALID_ERRCODE, ClientExceptionConstant.TOKEN_INVALID_ERRMSG);
        }
    }

    //查询注册信息
    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestAttribute Integer administratorId){
        Administrator administrator = administratorService.getById(administratorId);
        AdministratorGetProfileOutDTO administratorGetProfileOutDTO = new AdministratorGetProfileOutDTO();
        administratorGetProfileOutDTO.setAdministratorId(administrator.getAdministratorId());
        administratorGetProfileOutDTO.setUsername(administrator.getUsername());
        administratorGetProfileOutDTO.setRealName(administrator.getRealName());
        administratorGetProfileOutDTO.setEmail(administrator.getEmail());
        administratorGetProfileOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administratorGetProfileOutDTO.setCreateTime(administrator.getCreateTime().getTime());

        return administratorGetProfileOutDTO;
    }

    //修改注册信息
    @PostMapping("/updateProfile")
    public  void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO,
                               @RequestAttribute Integer administratorId){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorId);
        administrator.setRealName(administratorUpdateProfileInDTO.getRealName());
        administrator.setAvatarUrl(administratorUpdateProfileInDTO.getAvatarUrl());
        administrator.setEmail(administratorUpdateProfileInDTO.getEmail());
        administratorService.updateProfile(administrator);
    }

    //修改密码
    @PostMapping("/changePwd")
    public void changePwd(@RequestBody AdministratorChangePwdInDTO administratorChangePwdInDTO,
                          @RequestAttribute Integer administratorId){

    }

    //根据邮件查找密码
    @GetMapping("/getPwdResetCode")
    public void getPedRestCode(@RequestParam String email) throws ClientException {
        Administrator administrator = administratorService.getByEmail(email);
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_EMAIL_NOT_EXIST_ERRCODE,ClientExceptionConstant.ADMINISTRATOR_EMAIL_NOT_EXIST_ERRMSG);
        }
        byte[] bytes = secureRandom.generateSeed(3);
        String hex = DatatypeConverter.printHexBinary(bytes);
        emailUtil.send(fromEmail,email,"电商管理员密码重置",hex);
        emailPwdResetCodeMap.put(email,hex);
    }

    //重置密码
    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody AdministratorResetPedInDTO administratorResetPedInDTO) throws ClientException {
        String email = administratorResetPedInDTO.getEmail();
        String innerResetCode = emailPwdResetCodeMap.get(email);
        if (email == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_PWDRESET_EMAIL_NONE_ERRCODE, ClientExceptionConstant.ADMINISTRATOR_PWDRESET_EMAIL_NONE_ERRMSG);
        }
        if (innerResetCode == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_PWDRESET_INNER_RESETCODE_NONE_ERRCODE,ClientExceptionConstant.ADMINISTRATOR_PWDRESET_INNER_RESETCODE_NONE_ERRMSG);
        }
        String outerResetCode = administratorResetPedInDTO.getResetCode();
        if (outerResetCode == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_PWDRESET_OUTER_RESETCODE_NONE_ERRCODE,ClientExceptionConstant.ADMINISTRATOR_PWDRESET_OUTER_RESETCODE_NONE_ERRMSG);
        }
        if (!outerResetCode.equalsIgnoreCase(innerResetCode)){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_PWDRESET_RESETCODE_INVALID_ERRCODE,ClientExceptionConstant.ADMINISTRATOR_PWDRESET_RESETCODE_INVALID_ERRMSG);
        }
        Administrator administrator = administratorService.getByEmail(email);
        if (administrator == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_EMAIL_NOT_EXIST_ERRCODE,ClientExceptionConstant.ADMINISTRATOR_EMAIL_NOT_EXIST_ERRMSG);
        }
        String newPed = administratorResetPedInDTO.getNewPed();
        if (newPed == null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_NEWPWD_NOT_EXIST_ERRCODE,ClientExceptionConstant.ADMINISTRATOR_NEWPWD_NOT_EXIST_ERRMSG);
        }
        String bcrypHashString = BCrypt.withDefaults().hashToString(12,newPed.toCharArray());
        administrator.setEncryptedPassword(bcrypHashString);
        administratorService.update(administrator);

        emailPwdResetCodeMap.remove(email);

    }

    //显示页面上的参数
    @GetMapping("/getList")
    public PageInfo<Administrator> getList(@RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Administrator> administrators = administratorService.getList();
        PageInfo<Administrator> pageInfo = new PageInfo<>(administrators);
        return pageInfo;
    }

    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(Integer administratorId){
        Administrator administrator = administratorService.getById(administratorId);
        AdministratorShowOutDTO administratorShowOutDTO = new AdministratorShowOutDTO();
        administratorShowOutDTO.setAdministratorId(administratorId);
        administratorShowOutDTO.setUsername(administrator.getUsername());
        administratorShowOutDTO.setRealName(administrator.getRealName());
        administratorShowOutDTO.setEmail(administrator.getEmail());
        administratorShowOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administratorShowOutDTO.setStatus(administrator.getStatus());

        return administratorShowOutDTO;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
        Administrator administrator = new Administrator();
        administrator.setUsername(administratorCreateInDTO.getUsername());
        administrator.setRealName(administratorCreateInDTO.getRealName());
        administrator.setEmail(administratorCreateInDTO.getEmail());
        administrator.setAvatarUrl(administratorCreateInDTO.getAvatarUrl());
        administrator.setStatus((byte) AdministratorStatus.Enable.ordinal());
        administrator.setCreateTime(new Date());
        String password = BCrypt.withDefaults().hashToString(12, administratorCreateInDTO.getPassword().toCharArray());
        administrator.setEncryptedPassword(password);
        Integer administratorId = administratorService.create(administrator);
        return administratorId;
    }

    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){
        Administrator administrator = new Administrator();
        administrator.setAdministratorId(administratorUpdateInDTO.getAdministratorId());
        administrator.setRealName(administratorUpdateInDTO.getRealName());
        administrator.setEmail(administratorUpdateInDTO.getEmail());
        administrator.setStatus(administratorUpdateInDTO.getStatus());
        administrator.setAvatarUrl(administratorUpdateInDTO.getAvatarUrl());
        String password = administratorUpdateInDTO.getPassword();
        if (password != null && !password.isEmpty()){
            String passwordUpdate = BCrypt.withDefaults().hashToString(12, password.toCharArray());
            administrator.setEncryptedPassword(passwordUpdate);
        }
        administratorService.update(administrator);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){
        administratorService.delete(administratorId);
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> administratorIds){
        administratorService.batchDelete(administratorIds);
    }



}
