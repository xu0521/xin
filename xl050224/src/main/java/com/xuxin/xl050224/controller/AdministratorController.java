package com.xuxin.xl050224.controller;

import com.xuxin.xl050224.dto.in.AdministratorLoginInDTO;
import com.xuxin.xl050224.dto.in.AdministratorUpdateProfileInDTO;
import com.xuxin.xl050224.dto.out.AdministratorGetProfileOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public String login(@RequestParam AdministratorLoginInDTO administratorLoginInDTO){
        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(Integer administratorId){
        return null;
    }

    @PostMapping("/updateProfile")
    public  void updateProfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }

}
