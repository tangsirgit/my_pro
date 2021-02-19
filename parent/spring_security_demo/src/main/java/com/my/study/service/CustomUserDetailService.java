package com.my.study.service;

import com.my.study.dao.UserDao;
import com.my.study.entity.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : tanghuai
 * @date : 2021/2/18 10:45
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
    @Resource
    private UserDao userDao;

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户
        UserDO userByUserLogin = userDao.findUserByUserLogin(username);
        if (userByUserLogin == null) {
            log.warn("User:{} not found", username);
            throw new UsernameNotFoundException("User " + username + " was not found in db");
            //这里找不到必须抛异常
        }

        // 2.设置角色
        return new User(username, userByUserLogin.getPassword(), AuthorityUtils.createAuthorityList());
    }
}
