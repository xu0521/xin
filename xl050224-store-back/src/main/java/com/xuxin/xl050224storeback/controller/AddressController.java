package com.xuxin.xl050224storeback.controller;


import com.xuxin.xl050224storeback.dto.in.AddressCreateInDto;
import com.xuxin.xl050224storeback.dto.in.AddressUpdateInDTO;
import com.xuxin.xl050224storeback.dto.out.AddressListOutDTO;
import com.xuxin.xl050224storeback.dto.out.AddressShowOutDTO;
import com.xuxin.xl050224storeback.entity.Address;
import com.xuxin.xl050224storeback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(@RequestParam Integer customerId) {
        return null;
    }

    @GetMapping("/getById")
    public AddressShowOutDTO getById(@RequestParam Integer addressId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateInDto addressCreateInDto,
                          @RequestAttribute Integer customerId) {
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setTag(addressCreateInDto.getTag());
        address.setReceiverName(addressCreateInDto.getReceiverName());
        address.setReceiverMobile(addressCreateInDto.getReceiverMobile());
        address.setContent(addressCreateInDto.getContent());
        addressService.create(address);
        Integer addressId = address.getAddressId();
        return addressId;
    }

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO,
                       @RequestAttribute Integer customerId) {

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer addressId) {

    }
}
