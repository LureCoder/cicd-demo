package com.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * test
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.cicd")
public class CICDDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(CICDDemoApp.class, args);
    }
}
