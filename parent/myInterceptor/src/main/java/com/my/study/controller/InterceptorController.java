package com.my.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拦截器测试接口
 * @author : admin
 * @date : 2020/12/24 16:40
 */
@RestController
@RequestMapping("/")
@Api(tags = {"拦截器测试接口"})
public class InterceptorController {

    @GetMapping("/testInterceptor")
    @ApiOperation("测试拦截器接口")
    public String testInterceptor(){
        System.out.println("testInterceptor");
        return "OK";
    }
}
