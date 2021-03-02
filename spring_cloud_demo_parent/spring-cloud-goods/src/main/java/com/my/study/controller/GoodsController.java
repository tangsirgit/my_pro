package com.my.study.controller;

import com.my.study.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanghuai
 * @date 2021/3/2
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/goodsSearch")
    public String goodsSearch() {
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        return "搜索成功" + user.toString();
    }
}
