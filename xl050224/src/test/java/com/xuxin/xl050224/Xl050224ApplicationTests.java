package com.xuxin.xl050224;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Xl050224ApplicationTests {

    @Test
    void contextLoads() {
        String password = "123456";
        String s = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        System.out.println(s);
    }

}
