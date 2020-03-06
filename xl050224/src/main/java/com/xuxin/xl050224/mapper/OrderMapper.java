package com.xuxin.xl050224.mapper;

import com.xuxin.xl050224.dto.out.OrderListOutDTO;
import com.xuxin.xl050224.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderListOutDTO> selectOrderList();
}