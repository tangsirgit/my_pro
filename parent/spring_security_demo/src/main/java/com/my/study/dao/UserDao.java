package com.my.study.dao;

import com.my.study.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author : tanghuai
 * @date : 2021/2/18 10:47
 */
@Mapper
public interface UserDao {
    /**
     * 根据登录名查询用户
     *
     * @param login 登录名
     * @return 用户信息
     */
    @Select("SELECT * FROM  user WHERE login = #{login} ")
    UserDO findUserByUserLogin(String login);
}
