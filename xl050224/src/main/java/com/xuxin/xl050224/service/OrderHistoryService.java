package com.xuxin.xl050224.service;

import com.xuxin.xl050224.entity.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);

    Long create(OrderHistory orderHistory);

}
