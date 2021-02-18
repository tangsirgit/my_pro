package com.my.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体
 *
 * @author : tanghuai
 * @date : 2021/2/18 10:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String login;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户角色
     */
    private String role;

}
