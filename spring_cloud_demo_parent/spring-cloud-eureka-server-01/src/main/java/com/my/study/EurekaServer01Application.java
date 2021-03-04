package com.my.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka服务注册中心
 *
 * @author : tanghuai
 * @date : 2021/3/4 11:49
 */
@SpringBootApplication
@EnableEurekaServer // 开启eureka服务端
public class EurekaServer01Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer01Application.class, args);
    }
}
