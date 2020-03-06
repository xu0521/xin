package com.xuxin.xl050224.controller;

import com.xuxin.xl050224.dto.out.AddressListOutDTO;
import com.xuxin.xl050224.dto.out.AddressShowOutDTO;
import com.xuxin.xl050224.entity.Address;
import com.xuxin.xl050224.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(@RequestParam Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public AddressShowOutDTO getById(Integer addressId){
        Address address = addressService.getById(addressId);
        AddressShowOutDTO addressShowOutDTO = new AddressShowOutDTO();
        addressShowOutDTO.setAddressId(addressId);
        addressShowOutDTO.setContent(address.getContent());
        addressShowOutDTO.setReceiverMobile(address.getReceiverMobile());
        addressShowOutDTO.setReceiverName(address.getReceiverName());
        addressShowOutDTO.setTag(address.getTag());
        return addressShowOutDTO;
    }
}
