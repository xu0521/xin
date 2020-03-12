package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.OrderSearchInDTO;
import com.xuxin.xl050224.dto.out.OrderInvoiceShowOutDTO;
import com.xuxin.xl050224.dto.out.OrderListOutDTO;
import com.xuxin.xl050224.dto.out.OrderShipShowOutDTO;
import com.xuxin.xl050224.dto.out.OrderShowOutDTO;
import com.xuxin.xl050224.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/search")
    public PageInfo<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                            @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<OrderListOutDTO> orderListOutDTOS = orderService.search(orderSearchInDTO);
        PageInfo<OrderListOutDTO> pageInfo = new PageInfo<>(orderListOutDTOS);
        return pageInfo;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
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
