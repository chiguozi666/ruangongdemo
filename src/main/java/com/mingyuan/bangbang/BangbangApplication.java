package com.mingyuan.bangbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.mingyuan.bangbang"})
public class BangbangApplication {

    public static void main(String[] args) {
        SpringApplication.run(BangbangApplication.class, args);
    }

}
