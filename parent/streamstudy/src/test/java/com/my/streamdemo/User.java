package com.my.streamdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : tanghuai
 * @date : 2021/2/24 17:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer age;
}
