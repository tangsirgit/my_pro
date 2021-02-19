package com.my.study.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : tanghuai
 * @date : 2021/2/18 10:16
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/toLogin")
    public ModelAndView toLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping("/loginSuccess")
    public ModelAndView loginSuccess() {
        ModelAndView modelAndView = new ModelAndView("main");
        return modelAndView;
    }

    @RequestMapping("/loginFail")
    public ModelAndView loginFail() {
        ModelAndView modelAndView = new ModelAndView("fail");
        return modelAndView;
    }

    @GetMapping("/getInfo")
    public String getInfo() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        }
        return userName;
    }
}
