package com.xuxin.xl050224storeback.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224storeback.dto.in.ReturnApplyInDTO;
import com.xuxin.xl050224storeback.dto.out.ReturnListOutDTO;
import com.xuxin.xl050224storeback.dto.out.ReturnShowOutDTO;
import com.xuxin.xl050224storeback.entity.Return;
import com.xuxin.xl050224storeback.enumeration.ReturnStatus;
import com.xuxin.xl050224storeback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,
                         @RequestAttribute Integer customerId){
        Return aReturn = new Return();
        aReturn.setOrderId(returnApplyInDTO.getOrderId());
        aReturn.setOrderTime(new Date(returnApplyInDTO.getOrderTimestamp()));
        aReturn.setCustomerId(customerId);
        aReturn.setCustomerName(returnApplyInDTO.getCustomerName());
        aReturn.setMobile(returnApplyInDTO.getMobile());
        aReturn.setEmail(returnApplyInDTO.getEmail());
        aReturn.setStatus((byte) ReturnStatus.ToProcess.ordinal());
        aReturn.setProductName(returnApplyInDTO.getProductName());
        aReturn.setProductCode(returnApplyInDTO.getProductCode());
        aReturn.setQuantity(returnApplyInDTO.getQuantity());
        aReturn.setReason(returnApplyInDTO.getReason());
        aReturn.setOpened(returnApplyInDTO.getOpened());
        aReturn.setComment(returnApplyInDTO.getComment());
        Date date = new Date();
        aReturn.setCreateTime(date);
        aReturn.setUpdateTime(date);
        returnService.create(aReturn);
        Integer returnId = aReturn.getReturnId();

        return returnId;
    }

    @GetMapping("/getList")
    public PageInfo<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                             @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Return> returns = returnService.getByCustomerId(customerId);
        List<ReturnListOutDTO> returnListOutDTOS = returns.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            returnListOutDTO.setStatus(aReturn.getStatus());
            return returnListOutDTO;
        }).collect(Collectors.toList());
        PageInfo<ReturnListOutDTO> pageInfo = new PageInfo<>(returnListOutDTOS);
        return pageInfo;
    }


    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }

}
