package com.xuxin.xl050224.service;

import com.xuxin.xl050224.dto.in.CustomerSearchInDTO;
import com.xuxin.xl050224.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> search(CustomerSearchInDTO customerSearchInDTO);

    Customer getById(Integer customerId);

}
