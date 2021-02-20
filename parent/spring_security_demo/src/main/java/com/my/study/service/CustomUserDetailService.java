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
import java.util.Arrays;

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
        System.out.println(userByUserLogin);
        if (userByUserLogin == null) {
            log.warn("User:{} not found", username);
            throw new UsernameNotFoundException("User " + username + " was not found in db");
            //这里找不到必须抛异常
        }

        // 2.设置角色
        // 在spring-security中，对角色的命名有严格的规则，要求角色名称的前缀必须是ROLE_。不要再数据库中保存
        // 再Spring-security中，角色和权限是平等的，都代表用户的访问权限。
        // 处理角色的名称问题
        String[] authorities = new String[userByUserLogin.getRoles().size() + userByUserLogin.getResources().size()];
        for (int i = 0; i < userByUserLogin.getRoles().size(); i++) {
            authorities[i] = "ROLE_" + userByUserLogin.getRoles().get(i);
        }
        for (int i = 0; i < userByUserLogin.getResources().size(); i++) {
            authorities[userByUserLogin.getRoles().size() + i] = userByUserLogin.getResources().get(i);
        }
        System.out.println(Arrays.toString(authorities));
        return new User(username, userByUserLogin.getPassword(), AuthorityUtils.createAuthorityList(authorities));
    }
}
