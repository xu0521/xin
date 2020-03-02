package com.xuxin.xl050224.mapper;

import com.xuxin.xl050224.entity.Administrator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator selectByUserName(@Param("username") String username);

    int batchDelete(@Param("administratorIds") List<Integer> administratorIds);

    List<Administrator> getList();
}