package com.my.emplogin.config;

import com.my.emplogin.annotation.RedisAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;



/**
 * redis缓存AOP
 *
 * @author : tanghuai
 * @date : 2021/1/21 9:49
 */
@Aspect
@Component
@Slf4j
public class RedisAopAspect {
    private static final Logger getLog = LoggerFactory.getLogger(RedisAopAspect.class);

    @Autowired
    private RedisTemplate redisTemplate;


    @Pointcut("@annotation(com.my.emplogin.annotation.RedisAnnotation)")
    public void redisAopAspect(){}


    @Around("redisAopAspect()")
    public Object redisCache(ProceedingJoinPoint joinPoint){
        return null;
    }
}
