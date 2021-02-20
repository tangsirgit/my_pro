package com.my.study.dao;

import com.my.study.entity.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author : tanghuai
 * @date : 2021/2/18 10:47
 */
@Mapper
public interface UserDao {
    /**
     * 根据登录名查询用户
     *
     * @param username 登录名
     * @return 用户信息
     */
    @Select("SELECT * FROM  tb_user WHERE username = #{username} ")
    @Results({
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "findRolesByUserId")),
            @Result(property = "resources", column = "id", javaType = List.class, many = @Many(select = "findResourceByUserId"))
    })
    UserDO findUserByUserLogin(String username);

    /**
     * 根据用户id查询角色集合
     *
     * @param userId 用户id
     * @return 角色集合
     */
    @Select("SELECT c.role_name FROM tb_user a " +
            "INNER JOIN tb_user_role b ON a.id = b .user_id " +
            "INNER JOIN tb_role c ON b.role_id = c.id WHERE a.id = #{userId} ")
    List<String> findRolesByUserId(Integer userId);

    /**
     * 根据用户id查询角色资源集合
     *
     * @param userId 用户id
     * @return 角色资源
     */
    @Select("SELECT d.res FROM tb_user a " +
            "INNER JOIN tb_user_role b ON a.id = b.user_id " +
            "INNER JOIN tb_role_res c ON b.role_id = c.role_id " +
            "INNER JOIN tb_resource d ON c.res_id = d.id WHERE a.id = #{userId} ")
    List<String> findResourceByUserId(Integer userId);
}
