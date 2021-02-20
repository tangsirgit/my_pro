package com.my.study.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 403状态码
 *
 * @author : tanghuai
 * @date : 2021/2/20 16:30
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        // 设置响应状态
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        // 设置响应类型
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        // 响应输出
        httpServletResponse.getWriter().print("<h1>权限不足，联系管理员</h1>");
        // 刷新流
        httpServletResponse.getWriter().flush();
    }
}
