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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(@RequestAttribute Integer customerId) {
        List<Address> addresses = addressService.getAddressList(customerId);

        List<AddressListOutDTO> addressListOutDTOS = addresses.stream().map(address -> {
            AddressListOutDTO addressListOutDTO = new AddressListOutDTO();
            addressListOutDTO.setAddressId(address.getAddressId());
            addressListOutDTO.setTag(address.getTag());
            addressListOutDTO.setReceiverName(address.getReceiverName());
            addressListOutDTO.setReceiverMobile(address.getReceiverMobile());
            addressListOutDTO.setContent(address.getContent());
            return addressListOutDTO;
        }).collect(Collectors.toList());
        return addressListOutDTOS;
    }

    @GetMapping("/getById")
    public AddressShowOutDTO getById(@RequestParam Integer addressId){
        Address address = addressService.getById(addressId);

        AddressShowOutDTO addressShowOutDTO = new AddressShowOutDTO();
        addressShowOutDTO.setAddressId(addressId);
        addressShowOutDTO.setReceiverName(address.getReceiverName());
        addressShowOutDTO.setTag(address.getTag());
        addressShowOutDTO.setReceiverMobile(address.getReceiverMobile());
        addressShowOutDTO.setContent(address.getContent());

        return addressShowOutDTO;
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
    public void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO) {
        Address address = new Address();
        address.setAddressId(addressUpdateInDTO.getAddressId());
        address.setTag(addressUpdateInDTO.getTag());
        address.setReceiverMobile(addressUpdateInDTO.getReceiverMobile());
        address.setReceiverName(addressUpdateInDTO.getReceiverName());
        address.setContent(addressUpdateInDTO.getContent());
        addressService.update(address);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer addressId) {
        addressService.delete(addressId);
    }
}
