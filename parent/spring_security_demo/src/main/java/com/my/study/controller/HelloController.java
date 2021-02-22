package com.my.study.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    /**
     * 基于security注解的配置，角色
     *
     * @return
     */
    @RequestMapping("/all/read")
    //@Secured({"ROLE_访客","ROLE_管理员"})
    @PreAuthorize("hasAnyAuthority('admin:read','guest:read')")
    public String allRead() {
        return "所有用户都可以访问";
    }

    /**
     * 基于security注解的配置，资源
     * 相当于配置中的access()方法，写动态表达式
     *
     * @return
     */
    @RequestMapping("/guest/read")
    @PreAuthorize("hasAnyAuthority('guest:read')")
    public String guestRead() {
        return "访客可以访问";
    }

    @RequestMapping("/admin/read")
    @Secured({"ROLE_管理员"})
    public String adminRead() {
        return "管理员可以访问";
    }

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
