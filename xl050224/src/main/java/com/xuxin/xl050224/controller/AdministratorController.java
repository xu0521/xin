package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.*;
import com.xuxin.xl050224.dto.out.AdministratorGetProfileOutDTO;
import com.xuxin.xl050224.dto.out.AdministratorListOutDTO;
import com.xuxin.xl050224.dto.out.AdministratorShowOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    //登录
    @GetMapping("/login")
    public String login( AdministratorLoginInDTO administratorLoginInDTO){
        return null;
    }

    //查询注册信息
    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(Integer administratorId){
        return null;
    }

    //修改注册信息
    @PostMapping("/updateProfile")
    public  void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

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
