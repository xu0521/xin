package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.OrderSearchInDTO;
import com.xuxin.xl050224.dto.out.OrderInvoiceShowOutDTO;
import com.xuxin.xl050224.dto.out.OrderListOutDTO;
import com.xuxin.xl050224.dto.out.OrderShipShowOutDTO;
import com.xuxin.xl050224.dto.out.OrderShowOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    @GetMapping("/search")
    public PageInfo<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                            @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }

    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(@RequestParam Long orderId){
        return null;
    }

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestParam Long orderId){
        return null;
    }

}
