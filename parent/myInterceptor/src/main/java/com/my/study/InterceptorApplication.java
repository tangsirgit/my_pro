package com.my.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : admin
 * @date : 2020/12/24 16:38
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.my.study.config"})
public class InterceptorApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterceptorApplication.class,args);
    }
}
