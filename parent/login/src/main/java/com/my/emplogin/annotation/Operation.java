package com.my.emplogin.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author : tanghuai
 * @date : 2021/1/15 10:09
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Operation {
    String value() default "";
}
