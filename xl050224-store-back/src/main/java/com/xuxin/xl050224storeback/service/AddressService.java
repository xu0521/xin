package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.entity.Address;

import java.util.List;

public interface AddressService {

    Integer create(Address address);

    List<Address> getAddressList(Integer customerId);

}
