package com.xuxin.xl050224storeback.service.impl;

import com.xuxin.xl050224storeback.entity.Customer;
import com.xuxin.xl050224storeback.mapper.CustomerMapper;
import com.xuxin.xl050224storeback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Customer getByUsername(String username) {
        Customer customer = customerMapper.selectByUsername(username);
        return customer;
    }
}
