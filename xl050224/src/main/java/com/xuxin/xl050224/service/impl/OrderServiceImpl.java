package com.xuxin.xl050224.service.impl;

import com.alibaba.fastjson.JSON;
import com.xuxin.xl050224.dto.out.OrderListOutDTO;
import com.xuxin.xl050224.dto.out.OrderShowOutDTO;
import com.xuxin.xl050224.entity.Customer;
import com.xuxin.xl050224.entity.Order;
import com.xuxin.xl050224.entity.OrderDetail;
import com.xuxin.xl050224.mapper.OrderDetailMapper;
import com.xuxin.xl050224.mapper.OrderMapper;
import com.xuxin.xl050224.service.CustomerService;
import com.xuxin.xl050224.service.OrderService;
import com.xuxin.xl050224.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private CustomerService customerService;

    @Override
    public List<OrderListOutDTO> search() {
        List<OrderListOutDTO> orderListOutDTOS = orderMapper.selectOrderList();
        return orderListOutDTOS;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setCustomerId(order.getCustomerId());
        Customer customerById = customerService.getById(order.getCustomerId());
        orderShowOutDTO.setCustomerName(customerById.getRealName());
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());

        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);

        orderShowOutDTO.setOrderProduct(orderProductVOS);



        return orderShowOutDTO;
    }
}
