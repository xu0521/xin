package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.out.ReturnSearchOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/search")
    public PageInfo<ReturnSearchOutDTO> search(@RequestParam Integer returnId,
                                               @RequestParam String customerName,
                                               @RequestParam Integer orderId,
                                               @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }

}
