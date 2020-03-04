package com.xuxin.xl050224storeback.service.impl;

import com.xuxin.xl050224storeback.entity.Address;
import com.xuxin.xl050224storeback.mapper.AddressMapper;
import com.xuxin.xl050224storeback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public Integer create(Address address) {
        int addressId = addressMapper.insertSelective(address);
        return addressId;
    }
}
