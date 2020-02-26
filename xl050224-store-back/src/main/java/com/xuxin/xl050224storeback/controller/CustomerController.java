package com.xuxin.xl050224storeback.controller;


import com.xuxin.xl050224storeback.dto.in.*;
import com.xuxin.xl050224storeback.dto.out.CustomerGetProfileOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterInDTO customerRegisterInDTO){
        return null;
    }

    @GetMapping("/login")
    public String  login(CustomerLoginInDTO customerLoginInDTO){
        return null;
    }

    //查询注册信息
    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(Integer administratorId){
        return null;
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
