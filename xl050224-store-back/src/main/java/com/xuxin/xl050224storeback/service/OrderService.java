package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.dto.in.OrderCheckoutInDTO;

public interface OrderService {

    Long createOut(OrderCheckoutInDTO orderCheckoutInDTO,Integer customerId);
}
