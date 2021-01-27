package com.my.emplogin.dao;

import com.my.emplogin.entity.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : tanghuai
 * @date : 2021/1/15 10:43
 */
@Mapper
public interface LogMapper {

    /**
     * 日志保存
     * @param sysLog 日志记录
     */
    @Insert("INSERT INTO log_tb(user_id,user_ip,request_method,request_desc,create_time) " +
            "VALUES(#{sysLog.userId},#{sysLog.userIp},#{sysLog.requestMethod},#{sysLog.requestDesc},NOW())")
    void saveLog(@Param("sysLog") SysLog sysLog);
}
