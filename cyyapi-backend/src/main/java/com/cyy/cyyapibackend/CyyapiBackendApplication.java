package com.cyy.cyyapibackend;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.cyy.cyyapibackend.mapper"})
@SpringBootApplication
@EnableDubbo
public class CyyapiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyapiBackendApplication.class, args);
    }

}
