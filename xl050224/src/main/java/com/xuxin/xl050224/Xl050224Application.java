package com.xuxin.xl050224;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xuxin.xl050224.mapper")
public class Xl050224Application {

    public static void main(String[] args) {
        SpringApplication.run(Xl050224Application.class, args);
    }

}
