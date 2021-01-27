package com.my.study.config;


import com.my.study.MyInterceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/** 拦截器配置
 * @author : admin
 * @date : 2020/12/24 16:43
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/interceptor/testInterceptor");
    }
}
