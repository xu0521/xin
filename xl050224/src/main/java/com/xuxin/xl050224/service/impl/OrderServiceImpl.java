package com.xuxin.xl050224.service.impl;

import com.xuxin.xl050224.dto.out.OrderListOutDTO;
import com.xuxin.xl050224.dto.out.OrderShipShowOutDTO;
import com.xuxin.xl050224.dto.out.OrderShowOutDTO;
import com.xuxin.xl050224.entity.Order;
import com.xuxin.xl050224.entity.OrderDetail;
import com.xuxin.xl050224.mapper.OrderDetailMapper;
import com.xuxin.xl050224.mapper.OrderMapper;
import com.xuxin.xl050224.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderListOutDTO> search() {
        List<OrderListOutDTO> orderListOutDTOS = orderMapper.selectOrderList();
        return orderListOutDTOS;
    }

    @Override
    public OrderShipShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setCustomerId(order.getCustomerId());


        return null;
    }
}
