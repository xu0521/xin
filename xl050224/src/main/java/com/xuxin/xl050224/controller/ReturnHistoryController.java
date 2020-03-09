package com.xuxin.xl050224.controller;

import com.xuxin.xl050224.dto.in.ReturnHistoryCreateInDTO;
import com.xuxin.xl050224.dto.out.ReturnHistoryListOutDTO;
import com.xuxin.xl050224.entity.ReturnHistory;
import com.xuxin.xl050224.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/returnhistory")
public class ReturnHistoryController {

    @Autowired
    private ReturnHistoryService returnHistoryService;

    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(@RequestParam Integer returnId){
        List<ReturnHistory> returnHistories = returnHistoryService.getList(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = returnHistories.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setReturnHistoryId(returnHistory.getReturnHistoryId());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setCustomerNotified(returnHistory.getCustomerNotified());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        return returnHistoryListOutDTOS;
    }


    @PostMapping("/create")
    public Long create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        ReturnHistory returnHistory = new ReturnHistory();
        returnHistory.setReturnId(returnHistoryCreateInDTO.getReturnId());
        returnHistory.setTime(new Date());
        returnHistory.setReturnStatus(returnHistoryCreateInDTO.getReturnStatus());
        returnHistory.setComment(returnHistoryCreateInDTO.getComment());
        Boolean customerNotified = returnHistoryCreateInDTO.getCustomerNotified();
        returnHistory.setCustomerNotified(customerNotified);
        Long returnHistoryId = returnHistoryService.create(returnHistory);
        if (customerNotified != null && customerNotified){

        }
        return returnHistoryId;
    }


}
