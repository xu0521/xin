package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.dto.in.CustomerRegisterInDTO;
import com.xuxin.xl050224storeback.entity.Customer;

public interface CustomerService {

    Customer getByUsername(String username);

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getById(Integer customerId);

    void updateProfile(Customer customer);

    Customer getByEmail(String email);

}
