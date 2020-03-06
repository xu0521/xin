package com.xuxin.xl050224.service;

import com.xuxin.xl050224.dto.out.OrderListOutDTO;
import com.xuxin.xl050224.dto.out.OrderShipShowOutDTO;

import java.util.List;

public interface OrderService {

    List<OrderListOutDTO> search();

    OrderShipShowOutDTO getById(Long orderId);
}
