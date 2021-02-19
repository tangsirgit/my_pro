package com.my.study.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * java配置用户名到内存，看一看就行
 *
 * @author : tanghuai
 * @date : 2021/2/18 10:23
 */
// @Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin") // 添加用户admin
                .password("{noop}admin")  // 不设置密码加密
                .roles("ADMIN", "USER")// 添加角色为admin，user
                .and()
                .withUser("user") // 添加用户user
                .password("{noop}user")
                .roles("USER")
                .and()
                .withUser("tmp") // 添加用户tmp
                .password("{noop}tmp")
                .roles(); // 没有角色
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello/user").hasRole("USER") //添加/product/** 下的所有请求只能由user角色才能访问
                .antMatchers("/hello/admin").hasRole("ADMIN") //添加/admin/** 下的所有请求只能由admin角色才能访问
                .anyRequest().authenticated() // 没有定义的请求，所有的角色都可以访问（tmp也可以）。
                .and()
                .formLogin().and()
                .httpBasic();
    }
}
