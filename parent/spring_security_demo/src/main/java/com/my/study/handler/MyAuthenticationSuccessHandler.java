package com.my.study.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义的认证成功逻辑
 * <p>
 * 请求转发 request.getRequestDispatcher
 * 重定向 response.sendRedirect
 *
 * @author : tanghuai
 * @date : 2021/2/19 14:40
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private String url;
    private Boolean isRedirect;

    public MyAuthenticationSuccessHandler(String url, Boolean isRedirect) {
        this.url = url;
        this.isRedirect = isRedirect;
    }

    /**
     * @param httpServletRequest  request
     * @param httpServletResponse response
     * @param authentication      自己实现的UserDetailService的loadUserByUserName方法的返回对象
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if (isRedirect) {
            httpServletResponse.sendRedirect(url);
        } else {
            httpServletRequest.getRequestDispatcher(url).forward(httpServletRequest, httpServletResponse);
        }
    }
}
