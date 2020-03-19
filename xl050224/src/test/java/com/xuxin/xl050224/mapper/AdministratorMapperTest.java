package com.xuxin.xl050224.mapper;

import com.xuxin.xl050224.entity.Administrator;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdministratorMapperTest {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Test
    void selectByUserName() {
        String username = "admin";
        Administrator administrator = administratorMapper.selectByUserName(username);
        assertNotNull(administrator);
        username = "admin110";
        administrator = administratorMapper.selectByUserName(username);
        assertNull(administrator);
    }
}