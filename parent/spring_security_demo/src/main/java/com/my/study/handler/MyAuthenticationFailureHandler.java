package com.my.study.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求失败策略
 *
 * @author : tanghuai
 * @date : 2021/2/19 15:49
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private String url;
    private Boolean isRedirect;

    public MyAuthenticationFailureHandler(String url, Boolean isRedirect) {
        this.url = url;
        this.isRedirect = isRedirect;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (isRedirect) {
            httpServletResponse.sendRedirect(url);
        } else {
            httpServletRequest.getRequestDispatcher(url).forward(httpServletRequest, httpServletResponse);
        }
    }
}
