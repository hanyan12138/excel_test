package com.example.hanyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author vigo.xian
 */
@EnableAsync
@SpringBootApplication
@MapperScan(basePackages = {"com.example.hanyan.hanee.mapper"})
public class ExcelTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelTestApplication.class, args);
    }

}
