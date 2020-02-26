package com.xuxin.xl050224storeback.controller;


import com.xuxin.xl050224storeback.dto.in.AddressCreateInDto;
import com.xuxin.xl050224storeback.dto.in.AddressUpdateInDTO;
import com.xuxin.xl050224storeback.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {


    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateInDto addressCreateInDto,
                          @RequestAttribute Integer customerId){
        return null;
    }

    @PostMapping("/update")
    public  void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO,
                        @RequestAttribute Integer customerId){

    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer addressId){

    }
}
