package com.hhw.javaleaning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hhw.javaleaning.mapper")
public class JavaLeaningApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaLeaningApplication.class, args);
    }

}
