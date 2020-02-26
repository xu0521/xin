package com.xuxin.xl050224storeback.mapper;

import com.xuxin.xl050224storeback.entity.OrderHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryMapper {
    int deleteByPrimaryKey(Long orderHistoryId);

    int insert(OrderHistory record);

    int insertSelective(OrderHistory record);

    OrderHistory selectByPrimaryKey(Long orderHistoryId);

    int updateByPrimaryKeySelective(OrderHistory record);

    int updateByPrimaryKey(OrderHistory record);
}