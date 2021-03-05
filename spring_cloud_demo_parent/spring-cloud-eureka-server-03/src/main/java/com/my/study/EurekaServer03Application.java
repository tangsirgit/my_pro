package com.my.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : tanghuai
 * @date : 2021/3/5 13:46
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer03Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer03Application.class, args);
    }
}
