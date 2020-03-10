package com.xuxin.xl050224storeback.controller;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.xuxin.xl050224storeback.constant.ClientExceptionConstant;
import com.xuxin.xl050224storeback.dto.in.*;
import com.xuxin.xl050224storeback.dto.out.CustomerGetProfileOutDTO;
import com.xuxin.xl050224storeback.dto.out.CustomerLoginOutDTO;
import com.xuxin.xl050224storeback.entity.Customer;
import com.xuxin.xl050224storeback.exception.ClientException;
import com.xuxin.xl050224storeback.service.CustomerService;
import com.xuxin.xl050224storeback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterInDTO customerRegisterInDTO){
        Integer customerId = customerService.register(customerRegisterInDTO);
        return customerId;
    }

    @GetMapping("/login")
    public CustomerLoginOutDTO  login(CustomerLoginInDTO customerLoginInDTO) throws ClientException {
        Customer customer = customerService.getByUsername(customerLoginInDTO.getUsername());
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE,ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }
        String encryptedPassword = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerLoginInDTO.getPassword().toCharArray(), encryptedPassword);
        if (result.verified){
            CustomerLoginOutDTO customerLoginOutDTO = jwtUtil.issueToken(customer);
            return customerLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }
    }

    //查询注册信息
    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(@RequestAttribute Integer customerId){
        Customer customer   = customerService.getById(customerId);
        CustomerGetProfileOutDTO customerGetProfileOutDTO = new CustomerGetProfileOutDTO();
        customerGetProfileOutDTO.setCustomerId(customerId);
        customerGetProfileOutDTO.setUsername(customer.getUsername());
        customerGetProfileOutDTO.setRealName(customer.getRealName());
        customerGetProfileOutDTO.setEmail(customer.getEmail());
        customerGetProfileOutDTO.setEmailVerified(customer.getEmailVerified());
        customerGetProfileOutDTO.setMobile(customer.getMobile());
        customerGetProfileOutDTO.setMobileVerified(customer.getMobileVerified());

        return customerGetProfileOutDTO;
    }

    //修改注册信息
    @PostMapping("/updateProfile")
    public  void updateProfile(@RequestBody CustomerUpdateProfileInDTO customerUpdateProfileInDTO){

    }

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdInDTO customerChangePwdInDTO,
                          @RequestAttribute Integer customerId){

    }

    //根据邮件查找密码
    @GetMapping("/getPwdResetCode")
    public String getPedRestCode(@RequestParam String email){
        return null;
    }

    //重置密码
    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody CustomerResetPedInDTO customerResetPedInDTO){

    }

}
