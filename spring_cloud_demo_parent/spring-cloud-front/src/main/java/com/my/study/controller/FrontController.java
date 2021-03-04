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
     * Eureka和Zookeeper区别，cap原理
     *
     * zookeeper的cp性，一致和分区容错性，由于选举机制，会导致系统暂时瘫痪
     * Eureka的ca性，可用性和分区容错性，个个节点是平等的
     */


    /**
     * 写死远程调用地址
     */
    private static final String GOODS_SERVER_URL = "http://localhost:7010/goods/goodsSearch";

    private static final String GOODS_SERVER_URL_02 = "http://GOODS-SERVER/goods/goodsSearch";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/server/goods")
    public String getGoods() {
        // ResponseEntity<String> forEntity = restTemplate.getForEntity(GOODS_SERVER_URL, String.class);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(GOODS_SERVER_URL_02, String.class);
        return forEntity.getBody();
    }



}
