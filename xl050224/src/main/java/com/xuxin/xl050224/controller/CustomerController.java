package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.CustomerCreateInDTO;
import com.xuxin.xl050224.dto.in.CustomerUpdateInDTO;
import com.xuxin.xl050224.dto.out.CustomerGetCustomerOutDTO;
import com.xuxin.xl050224.dto.out.CustomerSearchOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/search")
    public PageInfo<CustomerSearchOutDTO> search(@RequestParam String username,
                                                 @RequestParam String email,
                                                 @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }

    @PostMapping("/create")
    public String  create(@RequestBody CustomerCreateInDTO customerCreateInDTO){
        return null;
    }

    @GetMapping("/getCustomer")
    public CustomerGetCustomerOutDTO getCustomer(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody CustomerUpdateInDTO customerUpdateInDTO){

    }

}
