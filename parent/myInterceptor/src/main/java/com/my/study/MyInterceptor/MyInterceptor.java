package com.my.study.MyInterceptor;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 自定义拦截器
 * @author : admin
 * @date : 2020/12/24 16:47
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登录拦截器
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(ObjectUtils.isEmpty(loginUser)){
            String path = session.getServletContext().getContextPath();
            response.sendRedirect(path+"/login");
            return false;
        }
        // 放行所有接口
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // controller 执行完毕
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        System.out.println("controller执行完毕");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 视图渲染结束
        System.out.println("视图渲染结束");
    }
}
