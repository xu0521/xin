package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.dto.in.OrderCheckoutInDTO;
import com.xuxin.xl050224storeback.entity.Order;

import java.util.List;

public interface OrderService {

    Long createOut(OrderCheckoutInDTO orderCheckoutInDTO,Integer customerId);

    List<Order> selectOrderByCustomer(Integer customerId);
}
