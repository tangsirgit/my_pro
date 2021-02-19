package com.my.study.config;

import com.my.study.handler.MyAuthenticationFailureHandler;
import com.my.study.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 使用数据库的用户
 *
 * @author : tanghuai
 * @date : 2021/2/18 10:40
 */
@Configuration
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 自定义权限访问设置，父类型中的配置逻辑
     *
     * @param http 基于http协议的security配置对象，包含所有的springsecurity相关配置
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .formLogin()
                .usernameParameter("username") // 设置请求参数中，用户名名称，默认username
                .passwordParameter("password") // 设置请求参数中，用户密码名称，默认password
                .loginPage("/hello/toLogin") // 当用户未登录时跳转,跳转的登录页面
                .loginProcessingUrl("/suibian") // 用户登录逻辑的请求地址是什么
                //.successForwardUrl("/hello/loginSuccess"); // 登录成功后的请求转发，处理post请求
                //.defaultSuccessUrl("/hello/loginSuccess"); // 登录成功后的重定向，get请求,
                .successHandler(new MyAuthenticationSuccessHandler("/hello/loginSuccess", true)) // 自定义认证处理逻辑，可以是请求转发，也可以是重定向。
                //.failureForwardUrl("/hello/loginFail"); // 失败之后的请求转发，处理的是post请求
                //.failureUrl("/hello/loginFail"); // 失败之后的响应重定向,记得提供权限认证
                .failureHandler(new MyAuthenticationFailureHandler("/hello/loginFail", true));


        /**
         * antMatches - 程序员最常用 基于匹配符
         * regexMatchers - 程序员排斥，推荐使用 , 正则表达式
         * anyRequest  相当于/**的antMatches
         */
        http
                .authorizeRequests().antMatchers("/hello/toLogin").permitAll() // /toLogin请求地址可以随意访问
                .antMatchers("/hello/loginFail").permitAll()
                .anyRequest().authenticated(); // 任意的请求，都必须认证

        http
                .csrf().disable();// 关闭csrf安全协议，为了完整流程可用

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance();// 使用不使用加密算法保持密码
        return new BCryptPasswordEncoder();
    }
}
