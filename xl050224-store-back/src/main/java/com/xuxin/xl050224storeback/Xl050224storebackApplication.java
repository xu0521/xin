package com.xuxin.xl050224storeback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xuxin.xl050224storeback.mapper")
public class Xl050224storebackApplication {

    public static void main(String[] args) {
        SpringApplication.run(Xl050224storebackApplication.class, args);
    }

}
