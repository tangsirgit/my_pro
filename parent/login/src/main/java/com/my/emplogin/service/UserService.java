package com.my.emplogin.service;

import com.my.emplogin.vo.req.LoginReqVO;
import com.my.emplogin.vo.req.RegisterReqVO;
import com.my.emplogin.vo.res.ResponseVO;
import com.my.emplogin.vo.res.UserSelfInfoResVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册service
 * @author : tanghuai
 * @date : 2021/1/11 14:04
 */
public interface UserService {

    /**
     * 注册
     * @param vo 注册请求体
     * @return
     */
    ResponseVO<String> register(RegisterReqVO vo);

    /**
     * 登录
     * @param vo 登录请求体
     * @param request
     * @param response
     * @return
     */
    ResponseVO<String> login(LoginReqVO vo, HttpServletRequest request , HttpServletResponse response);

    /**
     * 获取用户个人信息
     * @param userId 用户账号
     * @return
     */
    @Select("SELECT * FROM user_tb WHERE user_id = #{userId}")
    ResponseVO<UserSelfInfoResVO> getUserSelfInfo(@Param("userId") String userId);
}
