package com.my.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tanghuai
 * @date 2021/3/2
 */
@RestController
@RequestMapping("/front")
public class FrontController {
    /**
     * 写死远程调用地址
     */
    private static final String GOODS_SERVER_URL = "http://localhost:7010/goods/goodsSearch";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/server/goods")
    public String getGoods() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(GOODS_SERVER_URL, String.class);
        return forEntity.getBody();
    }
}
