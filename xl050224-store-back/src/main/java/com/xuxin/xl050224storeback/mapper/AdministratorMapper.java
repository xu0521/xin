package com.xuxin.xl050224storeback.mapper;

import com.xuxin.xl050224storeback.entity.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}