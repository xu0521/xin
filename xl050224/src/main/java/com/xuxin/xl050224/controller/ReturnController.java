package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.ReturnSearchInDTO;
import com.xuxin.xl050224.dto.in.ReturnUpdateInDTO;
import com.xuxin.xl050224.dto.out.ReturnListOutDTO;
import com.xuxin.xl050224.dto.out.ReturnShowOutDTO;
import com.xuxin.xl050224.entity.Return;
import com.xuxin.xl050224.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @GetMapping("/search")
    public PageInfo<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                             @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Return> search = returnService.search(returnSearchInDTO);
        List<ReturnListOutDTO> returnListOutDTOS = search.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setProductCode(aReturn.getProductCode());
            returnListOutDTO.setProductName(aReturn.getProductName());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            returnListOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());
        PageInfo<ReturnListOutDTO> pageInfo = new PageInfo<>(returnListOutDTOS);
        return pageInfo;
    }


    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody ReturnUpdateInDTO returnUpdateInDTO){

    }

}
