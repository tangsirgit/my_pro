package com.my.emplogin.entity;

import lombok.Data;

import java.util.Date;


/**
 * @author : tanghuai
 * @date : 2021/1/13 16:27
 */
@Data
public class TokenInfo {
    private String userId;
    private String token;
    private Date failTime;
    private Date createDate;
    private Integer status;
    private String ip;
}
