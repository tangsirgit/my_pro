package com.my.emplogin.controller;

import com.my.emplogin.annotation.Operation;
import com.my.emplogin.service.UserService;
import com.my.emplogin.util.MD5Util;
import com.my.emplogin.util.RandomValidateCodeUtil;
import com.my.emplogin.vo.req.LoginReqVO;
import com.my.emplogin.vo.req.RegisterReqVO;
import com.my.emplogin.vo.res.ResponseVO;
import com.my.emplogin.vo.res.UserSelfInfoResVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * 登录注册修改界面
 * @author : tanghuai
 * @date : 2021/1/11 14:02
 */
@RestController
@Api(tags = {"用户登录注册中心"})
@RequestMapping("/project/user")
@Slf4j
public class UserController {
    @Resource
    private UserService service;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/getVerify")
    @ApiOperation("验证码生成")
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
        try {
            // 设置相应头，相应类型
            response.setContentType("image/jpeg");
            // 告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCodeUtil = new RandomValidateCodeUtil();
            randomValidateCodeUtil.getRandomCode(request,response);
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>>>>>>>");
        }
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public ResponseVO<String> register(@Valid @RequestBody RegisterReqVO vo, HttpServletRequest request) {
        // 1 核对验证是否正确
        HttpSession session = request.getSession();
        String sessionVerifyCode = (String) session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        session.removeAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        // 2 验证不正确
        if (!vo.getVerifyCode().equalsIgnoreCase(sessionVerifyCode)) {
            return new ResponseVO<String>().error("输入验证码不正确");
        }

        // 3 密码加密
        vo.setPassword(MD5Util.convertMD5(vo.getPassword()));

        // 4 注册操作
        return service.register(vo);
    }

    @Operation("登录")
    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseVO<String> login(@Valid @RequestBody LoginReqVO vo, HttpServletRequest request ,
                                    HttpServletResponse response) {
        // 1 核实验证码
        HttpSession session = request.getSession();
        String sessionVerifyCode = (String) session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        session.removeAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        if (!vo.getVerifyCode().equalsIgnoreCase(sessionVerifyCode)){
            return new ResponseVO<String>().error("输入验证码不正确");
        }

        // 2 验证登录
        return service.login(vo,request,response);
    }

    @Operation(value = "获取个人信息")
    @PostMapping("/getUserSelfInfo")
    @ApiOperation("获取个人信息")
    public ResponseVO<UserSelfInfoResVO> getUserSelfInfo(HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return service.getUserSelfInfo(userId);
    }
}
