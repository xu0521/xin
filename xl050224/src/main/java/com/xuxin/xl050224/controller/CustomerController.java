package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.CustomerCreateInDTO;
import com.xuxin.xl050224.dto.in.CustomerSearchInDTO;
import com.xuxin.xl050224.dto.in.CustomerSetStatusInDTO;
import com.xuxin.xl050224.dto.in.CustomerUpdateInDTO;
import com.xuxin.xl050224.dto.out.CustomerListOutDTO;
import com.xuxin.xl050224.dto.out.CustomerShowOutDTO;
import com.xuxin.xl050224.entity.Address;
import com.xuxin.xl050224.entity.Customer;
import com.xuxin.xl050224.service.AddressService;
import com.xuxin.xl050224.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/search")
    public PageInfo<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                               @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Customer> customers = customerService.search(customerSearchInDTO);
        List<CustomerListOutDTO> customerListOutDTOS = customers.stream().map(customer -> {
            CustomerListOutDTO customerListOutDTO = new CustomerListOutDTO();
            customerListOutDTO.setCustomerId(customer.getCustomerId());
            customerListOutDTO.setUsername(customer.getUsername());
            customerListOutDTO.setRealName(customer.getRealName());
            customerListOutDTO.setMobile(customer.getMobile());
            customerListOutDTO.setEmail(customer.getEmail());
            customerListOutDTO.setStatus(customer.getStatus());
            customerListOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
            return customerListOutDTO;
        }).collect(Collectors.toList());
        PageInfo<CustomerListOutDTO> pageInfo = new PageInfo<>(customerListOutDTOS);
        return pageInfo;
    }

    @PostMapping("/create")
    public String  create(@RequestBody CustomerCreateInDTO customerCreateInDTO){
        return null;
    }

    @GetMapping("/getCustomer")
    public CustomerShowOutDTO getCustomer(@RequestParam Integer customerId){
        Customer customer = customerService.getById(customerId);
        CustomerShowOutDTO customerShowOutDTO = new CustomerShowOutDTO();
        customerShowOutDTO.setCustomerId(customerId);
        customerShowOutDTO.setUsername(customer.getUsername());
        customerShowOutDTO.setRealName(customer.getRealName());
        customerShowOutDTO.setMobile(customer.getMobile());
        customerShowOutDTO.setEmail(customer.getEmail());
        customerShowOutDTO.setDefaultAddressId(customer.getDefaultAddressId());
        customerShowOutDTO.setStatus(customer.getStatus());
        customerShowOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
        customerShowOutDTO.setNewsSubscribed(customer.getNewsSubscribed());
        customerShowOutDTO.setRewordPoints(customer.getRewordPoints());
        customerShowOutDTO.setAvatarUrl(customer.getAvatarUrl());

        Address addressById = addressService.getById(customer.getDefaultAddressId());
        if(addressById != null){
            customerShowOutDTO.setDefaultAddress(addressById.getContent());
        }


        return customerShowOutDTO;
    }

    @PostMapping("/update")
    public void update(@RequestBody CustomerUpdateInDTO customerUpdateInDTO){

    }

    @PostMapping("/setStatus")
    public void setStatus(@RequestBody CustomerSetStatusInDTO customerSetStatusInDTO){
        customerService.setStatus(customerSetStatusInDTO);
    }

}
