package com.my.emplogin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * redis缓存注解
 * @author : tanghuai
 * @date : 2021/1/21 9:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisAnnotation {
    // 用户标识key的前缀.
    public String value();
    // 如果用户不写表示不需要超时. 如果写了以用户为准
    public int seconds() default 0;
}
