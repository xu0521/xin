package com.xuxin.xl050224.service;

import com.xuxin.xl050224.entity.Address;

import java.util.List;

public interface AddressService {

    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);

}
