package com.xuxin.xl050224.service.impl;

import com.xuxin.xl050224.entity.Administrator;
import com.xuxin.xl050224.service.AdministratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdministratorServiceImplTest {

    @Autowired
    private AdministratorService administratorService;

    @Test
    void getByUsername() {
        String username = "admin";
        Administrator byUsername = administratorService.getByUsername(username);
        assertNotNull(byUsername);
        username = "admin110";
        byUsername = administratorService.getByUsername(username);
        assertNull(byUsername);
    }
}