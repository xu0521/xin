package com.xuxin.xl050224storeback.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224storeback.dto.in.OrderCheckoutInDTO;
import com.xuxin.xl050224storeback.dto.out.OrderShowOutDTO;
import com.xuxin.xl050224storeback.entity.Order;
import com.xuxin.xl050224storeback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId) {
        Long orderId = orderService.createOut(orderCheckoutInDTO, customerId);

        return orderId;
    }


    @GetMapping("/getList")
    public PageInfo<Order> getList(@RequestAttribute Integer customerId,
                                   @RequestParam(defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<Order> orders = orderService.selectOrderByCustomer(customerId);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return pageInfo;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId) {
        return null;
    }


}
