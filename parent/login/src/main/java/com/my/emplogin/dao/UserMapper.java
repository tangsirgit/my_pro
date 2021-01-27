package com.my.emplogin.dao;

import com.my.emplogin.entity.UserInfoDO;
import com.my.emplogin.vo.req.RegisterReqVO;
import com.my.emplogin.vo.res.UserSelfInfoResVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 注册mapper
 * @author : tanghuai
 * @date : 2021/1/11 14:07
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户账号查询用户是否存在
     * @param userId 用户账号
     * @return
     */
    @Select("SELECT COUNT(*) FROM user_tb WHERE user_id = #{userId}")
    Integer findCountByUserId(@Param("userId") String userId);

    /**
     * 新增用户
     * @param vo 新增用户请求体
     */
    @Insert("INSERT INTO user_tb(user_id,user_name,password,create_time,status) " +
            "VALUES(#{vo.userId},#{vo.userName},#{vo.password},NOW(),0)")
    void addUser(@Param("vo") RegisterReqVO vo);

    /**
     * 根据用户id，获取用户
     * @param userId 用户id
     * @return
     */
    @Select("SELECT * FROM user_tb WHERE user_id = #{userId}")
    UserInfoDO findUserByUserId(@Param("userId") String userId);
}
