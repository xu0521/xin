package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.CustomerCreateInDTO;
import com.xuxin.xl050224.dto.in.CustomerSearchInDTO;
import com.xuxin.xl050224.dto.in.CustomerUpdateInDTO;
import com.xuxin.xl050224.dto.out.CustomerListOutDTO;
import com.xuxin.xl050224.dto.out.CustomerShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/search")
    public PageInfo<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                               @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }

    @PostMapping("/create")
    public String  create(@RequestBody CustomerCreateInDTO customerCreateInDTO){
        return null;
    }

    @GetMapping("/getCustomer")
    public CustomerShowOutDTO getCustomer(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody CustomerUpdateInDTO customerUpdateInDTO){

    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){

    }

}
