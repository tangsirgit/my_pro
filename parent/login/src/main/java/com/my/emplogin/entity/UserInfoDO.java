package com.my.emplogin.entity;

import lombok.Data;

/**
 * @author : tanghuai
 * @date : 2021/1/12 21:05
 */
@Data
public class UserInfoDO {
    private String userId;
    private String userName;
    private String password;
    private String createTime;
    private String updateTime;
    private Integer status;
}
