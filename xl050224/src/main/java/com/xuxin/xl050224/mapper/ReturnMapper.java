package com.xuxin.xl050224.mapper;

import com.xuxin.xl050224.entity.Return;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    List<Return> selectByReturn(@Param("returnId") Integer returnId,
                                @Param("customerName") String customerName,
                                @Param("orderId") Long orderId,
                                @Param("productCode") String productCode,
                                @Param("productName") String productName,
                                @Param("status") Byte status);
}