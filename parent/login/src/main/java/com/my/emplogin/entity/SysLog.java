package com.my.emplogin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 日志类
 *
 * @author : tanghuai
 * @date : 2021/1/15 10:05
 */
@Data
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String logId;
    private String userId;
    private String userIp;
    private String requestMethod;
    private String requestDesc;
    private String createTime;
}
