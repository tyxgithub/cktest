package com.tyx.cktest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.tyx.cktest.mapper")
@EnableTransactionManagement
public class CktestApplication {
    public static void main(String[] args) {
        SpringApplication.run(CktestApplication.class, args);
    }

}
