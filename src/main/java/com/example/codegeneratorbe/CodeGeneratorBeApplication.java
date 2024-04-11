package com.example.codegeneratorbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EntityScan("com.example.codegeneratorbe.entity.*")
public class CodeGeneratorBeApplication {

    public static void main(String[] args) {SpringApplication.run(CodeGeneratorBeApplication.class, args);
    }

}