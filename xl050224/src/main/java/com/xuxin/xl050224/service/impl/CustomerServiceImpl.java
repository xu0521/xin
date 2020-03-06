package com.xuxin.xl050224.service.impl;

import com.xuxin.xl050224.dto.in.CustomerSearchInDTO;
import com.xuxin.xl050224.entity.Customer;
import com.xuxin.xl050224.mapper.CustomerMapper;
import com.xuxin.xl050224.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> search(CustomerSearchInDTO customerSearchInDTO) {
        List<Customer> search = customerMapper.search(customerSearchInDTO);
        return search;
    }

    @Override
    public Customer getById(Integer customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        return customer;
    }
}
