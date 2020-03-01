package com.xuxin.xl050224.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.constant.ClientExceptionConstant;
import com.xuxin.xl050224.dto.in.*;
import com.xuxin.xl050224.dto.out.AdministratorGetProfileOutDTO;
import com.xuxin.xl050224.dto.out.AdministratorListOutDTO;
import com.xuxin.xl050224.dto.out.AdministratorLoginOutDTO;
import com.xuxin.xl050224.dto.out.AdministratorShowOutDTO;
import com.xuxin.xl050224.entity.Administrator;
import com.xuxin.xl050224.exception.ClientException;
import com.xuxin.xl050224.service.AdministratorService;
import com.xuxin.xl050224.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private JWTUtil jwtUtil;

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
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
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

    }

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody AdministratorChangePwdInDTO administratorChangePwdInDTO,
                          @RequestAttribute Integer administratorId){

    }

    //根据邮件查找密码
    @GetMapping("/getPwdResetCode")
    public String getPedRestCode(@RequestParam String email){
        return null;
    }

    //重置密码
    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody AdministratorResetPedInDTO administratorResetPedInDTO){

    }

    //显示页面上的参数
    public PageInfo<AdministratorListOutDTO> getList(@RequestParam Integer pageNum){
        return null;
    }


    @GetMapping("/getById")
    public AdministratorShowOutDTO getById(Integer administratorId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer administratorId){

    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> administratorIds){

    }



}
