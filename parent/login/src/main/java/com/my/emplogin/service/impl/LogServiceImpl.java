package com.my.emplogin.service.impl;

import com.my.emplogin.dao.LogMapper;
import com.my.emplogin.entity.SysLog;
import com.my.emplogin.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : tanghuai
 * @date : 2021/1/15 10:13
 */
@Slf4j
@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogMapper mapper;

    @Override
    public void saveLog(SysLog sysLog) {
        mapper.saveLog(sysLog);
    }
}
