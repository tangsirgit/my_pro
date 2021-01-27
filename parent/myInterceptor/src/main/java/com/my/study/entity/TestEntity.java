package com.my.study.entity;

import lombok.Data;

/**
 * @author : admin
 * @date : 2021/1/7 15:23
 */
@Data
public class TestEntity {
    /**
     * 姓名
     */
    private String name;
    /**
     * id
     */
    private Integer id;
    /**
     * 审核时间
     */
    private String reviewTime;
}
