package com.example.spstu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.spstu.mapper")
public class SpStuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpStuApplication.class, args);
    }

}
