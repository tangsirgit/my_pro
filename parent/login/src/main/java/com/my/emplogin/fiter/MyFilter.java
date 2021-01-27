package com.my.emplogin.fiter;

import com.alibaba.fastjson.JSON;
import com.my.emplogin.dao.TokenMapper;
import com.my.emplogin.entity.TokenInfo;
import com.my.emplogin.vo.res.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 过滤器
 * @author : tanghuai
 * @date : 2021/1/11 14:01
 */
// @Component
@WebFilter(value = "MyFilter",urlPatterns = "/*")
@Slf4j
public class MyFilter implements Filter {
    @Resource
    private TokenMapper tokenMapper;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ResponseVO<Object> responseVO = new ResponseVO();
        // 获取请求路径
        String uriPath = request.getRequestURI();
        // 放行验证码和swagger文档
        if (uriPath.contains("/getVerify") ||
                uriPath.contains("/api-docs") ||
                uriPath.contains("swagger") ||
                uriPath.contains("/project/user/register") ||
                uriPath.contains("/project/user/login")){
            filterChain.doFilter(request,response);
            return;
        }

        // 验证token是否存在
        // TODO swagger中的token获取不到
        String token = request.getHeader("token");

        if (null == token && StringUtils.isEmpty(token)){
            responseVO.error(403,"用户未登录");
            // 写回错误消息
            returnMessage(response,responseVO);
            return;
        }

        TokenInfo tokenInfo = tokenMapper.findTokenInfoByToken(token);
        // 验证token是否失效
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(new Date());
        String failTime =sdf.format(tokenInfo.getFailTime());
        if (null != tokenInfo && failTime.compareTo(nowDate) < 0){
            // token已经失效
            responseVO.error(403,"登录失效，请重新登录");
            returnMessage(response,responseVO);
            return;
        }

        // 验证token成功，放行
        request.setAttribute("userId",tokenInfo.getUserId());
        filterChain.doFilter(request,response);
    }

    private void returnMessage(HttpServletResponse response, ResponseVO<Object> responseVO) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE+"; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSON.toJSONString(responseVO));
        } catch (IOException e) {
            log.error("网络异常",e);
        }
    }
}
