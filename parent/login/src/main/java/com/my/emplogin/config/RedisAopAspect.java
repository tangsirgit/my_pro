package com.my.emplogin.config;

import com.alibaba.fastjson.JSON;
import com.my.emplogin.annotation.RedisAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


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

    @Resource
    private RedisTemplate redisTemplate;


    @Pointcut("@annotation(com.my.emplogin.annotation.RedisAnnotation)")
    public void redisAopAspect(){}


    @Around("redisAopAspect()")
    public Object redisCache(ProceedingJoinPoint joinPoint) {

        getLog.info("进入环绕通知");
        try {
            RedisAnnotation redisAnnotation = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(RedisAnnotation.class);
            if (redisAnnotation != null && redisAnnotation.query()) {
                // 类路径 方法参数 方法名 加密生成redis key
                StringBuilder builder = new StringBuilder(joinPoint.getTarget().getClass().getName())
                        .append(JSON.toJSONString(joinPoint.getArgs()))
                        .append(joinPoint.getSignature().getName());
                String key = builder.toString();

                // 查询操作
                Object object = redisTemplate.opsForValue().get(key);
                if (object == null) {
                    // redis 中不存在，则数据库中查找，并保存到redis
                    getLog.info("Redis 中不存在该记录，从数据库查找");
                    object = joinPoint.proceed();
                    if (object != null) {
                        // 需要失效时间
                        if (redisAnnotation.seconds() > 0) {
                            redisTemplate.opsForValue().set(key, object, redisAnnotation.seconds(), TimeUnit.SECONDS);
                        } else {
                            // 不需要超时时间
                            redisTemplate.opsForValue().set(key, object);
                        }

                        return object;
                    }
                }
                getLog.info("查询redis");
                return object;
            }
        } catch (Throwable t) {
            t.printStackTrace();
            getLog.error("redis缓存执行异常");
        }

        return null;
    }
}
