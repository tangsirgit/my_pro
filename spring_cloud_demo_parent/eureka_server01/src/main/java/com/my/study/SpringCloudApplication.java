package com.my.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : tanghuai
 * @date : 2021/3/2 15:52
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApplication.class, args);
    }
}
