package com.my.study.config;

import com.my.study.handler.MyAccessDeniedHandler;
import com.my.study.handler.MyAuthenticationFailureHandler;
import com.my.study.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

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
     *
     */

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private PersistentTokenRepository persistentTokenRepository;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .formLogin()
                .usernameParameter("username") // 设置请求参数中，用户名名称，默认username
                .passwordParameter("password") // 设置请求参数中，用户密码名称，默认password
                .loginPage("/hello/toLogin") // 当用户未登录时跳转,跳转的登录页面 必须是get请求
                .loginProcessingUrl("/suibian") // 用户登录逻辑的请求地址
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
         *
         */

        /**
         * permitAll() 所有都可以访问,免登录访问，一般是通用资源，和登录页面等
         * anonymous() 匿名访问，登录之后不能访问
         * authenticated() 登录才能访问，保护资源，比如个人信息，订单查看，密码修改等
         * denyAll() 任意用户，任意状态都不能访问
         * fullyAuthenticated() 完整登录才能访问，描述敏感资源的，比如钱
         * rememberMe() 记住我 ， 自动登录|n天免登录，非敏感资源除钱操作相关意外的资源
         *
         * 以上方法都调用底层access()方法
         */
        http
                .authorizeRequests().antMatchers("/hello/toLogin").anonymous() // /toLogin请求地址可以随意访问
                .antMatchers("/hello/loginFail").permitAll()
                // 基于角色的权限管理
                //.antMatchers("/admin/read").hasRole("管理员")
                //.antMatchers("/guest/read").hasAnyRole("管理员","访客")
                //.antMatchers("/guest/write").hasRole("访客")


                // 客户端ip地址的权限管理，限制客户端的时候使用，提供给内部指定客户端访问
                // .antMatchers("/ip").hasIpAddress("127.0.0.1") // 客户端ip地址符合的

                // 基于资源管理的权限管理
                .antMatchers("/admin/read").hasAuthority("admin:read")
                .antMatchers("/guest/read").hasAnyAuthority("admin:read", "guest:read")
                .anyRequest().authenticated(); // 任意的请求，都必须认证

        // 自定义403无权限页面
        http
                .exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler());

        // 配置remember-me
        http.rememberMe()
                .rememberMeParameter("remember-me") // 配置remember-me的cookie名称，默认为remember-me
                .tokenValiditySeconds(60) // 配置remember-me的cookie有效时间，默认为14天，即记住我的时间。
                .userDetailsService(userDetailsService)
                .tokenRepository(persistentTokenRepository);

        http
                .csrf().disable();// 关闭csrf安全协议，为了完整流程可用

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance();// 使用不使用加密算法保持密码
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(DataSource dataSource){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);


        // 创建remember-me记录的数据库，第一次启动的时候使用，后面使用需要关闭，不然程序会报错
       // jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

}
