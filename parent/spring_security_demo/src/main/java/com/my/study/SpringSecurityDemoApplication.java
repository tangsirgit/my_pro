package com.my.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author : tanghuai
 * @date : 2021/2/18 9:31
 */
@SpringBootApplication(scanBasePackages = {"com.my.study.*"})
// 开启security注解扫描,securedEnabled,prePostEnabled
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }
}
