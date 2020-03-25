package com.dxs.fms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class FmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsApplication.class, args);
    }

}
