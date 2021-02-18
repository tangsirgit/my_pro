package com.my.study.service;

import com.my.study.Dao.UserDao;
import com.my.study.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author : tanghuai
 * @date : 2021/2/18 10:45
 */
@Component
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    @Resource
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 查询用户
        UserDO userByUserLogin = userDao.findUserByUserLogin(s);
        if (userByUserLogin == null) {
            log.warn("User:{} not found", s);
            throw new UsernameNotFoundException("User " + s + " was not found in db");
            //这里找不到必须抛异常
        }

        // 2.设置角色
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userByUserLogin.getRole());
        grantedAuthorities.add(grantedAuthority);
        return new User(s, userByUserLogin.getPassword(), grantedAuthorities);
    }
}
