package com.my.emplogin.service;

import com.my.emplogin.entity.SysLog;

/**
 * 日志service
 * @author : tanghuai
 * @date : 2021/1/15 10:12
 */
public interface LogService {
    /**
     * 保存日志到数据库
     * @param sysLog 日志实体
     */
    void saveLog(SysLog sysLog);
}
