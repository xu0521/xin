package com.xuxin.xl050224storeback.controller;


import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224storeback.dto.in.OrderCheckoutInDTO;
import com.xuxin.xl050224storeback.dto.out.OrderListOutDTO;
import com.xuxin.xl050224storeback.dto.out.OrderShowOutDTO;
import com.xuxin.xl050224storeback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public PageInfo<OrderListOutDTO> getList(@RequestAttribute Integer customerId,
                                             @RequestParam(defaultValue = "1") Integer pageNum) {
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId) {
        return null;
    }


}
