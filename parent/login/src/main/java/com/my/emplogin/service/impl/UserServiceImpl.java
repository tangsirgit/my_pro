package com.my.emplogin.service.impl;


import cn.hutool.system.SystemUtil;
import com.my.emplogin.annotation.RedisAnnotation;
import com.my.emplogin.dao.TokenMapper;
import com.my.emplogin.dao.UserMapper;
import com.my.emplogin.entity.TokenInfo;
import com.my.emplogin.entity.UserInfoDO;
import com.my.emplogin.service.UserService;
import com.my.emplogin.util.MD5Util;
import com.my.emplogin.vo.req.LoginReqVO;
import com.my.emplogin.vo.req.RegisterReqVO;
import com.my.emplogin.vo.res.ResponseVO;
import com.my.emplogin.vo.res.UserSelfInfoResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * @author : tanghuai
 * @date : 2021/1/11 14:05
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    @Resource
    private TokenMapper tokenMapper;

    @Value("${token.failTime}")
    private Integer failTime;
    @Override
    public ResponseVO<String> register(RegisterReqVO vo) {
        // 1 根据用户账号查询是否存在该账号
        Integer count = mapper.findCountByUserId(vo.getUserId());
        // 用户已经存在
        if (count > 0 ){
            return new ResponseVO<String>().error("用户已经存在");
        }
        // 2 新增用户
        mapper.addUser(vo);
        return new ResponseVO<>("注册成功!!！");
    }

    @Override
    public ResponseVO<String> login(LoginReqVO vo, HttpServletRequest request , HttpServletResponse response) {
        // 1 根据用户名获取数据库密码
        UserInfoDO userInfoDO = mapper.findUserByUserId(vo.getUserId());
        // 用户不存在
        if (userInfoDO == null){
            return new ResponseVO<String>().error("用户不存在");
        }
        String p = MD5Util.convertMD5(userInfoDO.getPassword());
        // 用户存在，判断用户输入密码是否正确
        if (!vo.getPassword().equals(p)){
            return new ResponseVO<String>().error("密码错误");
        }

        // 2 登录成功生成token
        TokenInfo tokenInfo = new TokenInfo();
        String token = UUID.randomUUID().toString();
        // 2.1保证token不重复
        if (tokenMapper.findToken(token) > 0){
            token = UUID.randomUUID().toString();
        }
        tokenInfo.setToken(token);
        // 2.3创建时间
        Date now = new Date();
        tokenInfo.setCreateDate(now);

        // 2.4配置token失效时间
        tokenInfo.setFailTime(new Date(now.getTime() + failTime * 1000 * 60));
        // 2.5用户id
        tokenInfo.setUserId(vo.getUserId());
        // 2.6token状态
        tokenInfo.setStatus(0);
        // 2.7登录ip地址
        String ipAddress = SystemUtil.getHostInfo().getAddress();
        tokenInfo.setIp(ipAddress);

        // 3 tokenInfo存入数据库
        if(!tokenMapper.saveTokenInfo(tokenInfo)){
            return new ResponseVO<String>().error("登录失败");
        }

        // 4 设置token到相应头
        response.setHeader("token",token);
        return new ResponseVO<>("登录成功!!!");
    }

    @Override
    @RedisAnnotation(key = "userBaseInfo", seconds = 100)
    public ResponseVO<UserSelfInfoResVO> getUserSelfInfo(String userId) {
        ResponseVO<UserSelfInfoResVO> resVOResponseVO = new ResponseVO<>();
        UserInfoDO userInfo = mapper.findUserByUserId(userId);
        UserSelfInfoResVO resVO= new UserSelfInfoResVO();
        BeanUtils.copyProperties(userInfo,resVO);
        resVOResponseVO.setContent(resVO);
        return resVOResponseVO;
    }

}
