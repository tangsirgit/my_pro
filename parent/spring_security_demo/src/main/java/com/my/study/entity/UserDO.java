package com.my.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 角色集合
     */
    private List<String> roles;

    /**
     * 资源集合
     */
    private List<String> resources;
}
