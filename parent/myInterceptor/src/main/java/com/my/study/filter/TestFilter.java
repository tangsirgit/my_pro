package com.my.study.filter;


import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author : tanghuai
 * @date : 2021/1/11 11:01
 */
@WebFilter(filterName = "TestFilter",urlPatterns = "/*")
@Component
public class TestFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request  = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestPath = request.getRequestURI();

        if (requestPath.contains("/mysqlTest/login") || requestPath.contains("/swagger-ui")){
            filterChain.doFilter(request,response);
            return;
        }

        HttpSession session = request.getSession();

        // 验证
        String token = (String) session.getAttribute("token");

        if (token == null){
            String result = JSON.toJSONString("用户未登录");
            writeResponse(response, result);
            return;
        }else {
            filterChain.doFilter(request,response);
            return;
        }
    }

    private void writeResponse(HttpServletResponse response, String result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter writer = response.getWriter();
        writer.write(result);
    }
}
