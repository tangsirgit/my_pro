package com.my.study.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : tanghuai
 * @date : 2021/2/18 10:16
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/user")
    public String testUser() {
        return "user";
    }

    @GetMapping("/admin")
    public String testAdmin() {
        return "admin";
    }

    @GetMapping("/allUser")
    public String testAllUser() {
        return "allUser";
    }

    @GetMapping("/info")
    public String info() {
        String userDetails = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userDetails = ((UserDetails) principal).getUsername();
        } else {
            userDetails = principal.toString();
        }
        return userDetails;
    }

    @GetMapping("testPass")
    public String testPass() {
        return "放行测试";
    }
}
