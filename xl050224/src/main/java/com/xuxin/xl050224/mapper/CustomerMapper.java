package com.xuxin.xl050224.mapper;

import com.xuxin.xl050224.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> search(@Param("username") String username,
                          @Param("realName") String realName,
                          @Param("mobile") String mobile,
                          @Param("email") String email,
                          @Param("status") Byte status);
}