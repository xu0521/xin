package com.xuxin.xl050224storeback.service.impl;

import com.xuxin.xl050224storeback.entity.Address;
import com.xuxin.xl050224storeback.mapper.AddressMapper;
import com.xuxin.xl050224storeback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public Integer create(Address address) {
        int addressId = addressMapper.insertSelective(address);
        return addressId;
    }

    @Override
    public List<Address> getAddressList(Integer customerId) {
        List<Address> addresses = addressMapper.selectAddressById(customerId);
        return addresses;
    }

    @Override
    public Address getById(Integer addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        return address;
    }

    @Override
    public void update(Address address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public void delete(Integer addressId) {
        addressMapper.deleteByPrimaryKey(addressId);
    }
}
