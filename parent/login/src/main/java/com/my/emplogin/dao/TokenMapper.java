package com.my.emplogin.dao;

import com.my.emplogin.entity.TokenInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author : tanghuai
 * @date : 2021/1/13 16:39
 */
@Mapper
public interface TokenMapper {

    /**
     * 查询token是否存在
     * @param token
     * @return
     */
    @Select("SELECT COUNT(*) FROM user_login_valid WHERE token = #{token}")
    Integer  findToken(@Param("token")String token);

    /**
     * 保存tokenInfo到数据库
     * @param tokenInfo  tokenInfo信息
     * @return
     */
    @Insert("INSERT INTO user_login_valid(user_id,token,fail_time,create_date,status,ip) " +
            "VALUES(#{tokenInfo.userId},#{tokenInfo.token},#{tokenInfo.failTime},#{tokenInfo.createDate}," +
            "#{tokenInfo.status},#{tokenInfo.ip})")
    boolean saveTokenInfo(@Param("tokenInfo") TokenInfo tokenInfo);

    /**
     * 查询token记录
     * @param token token
     * @return
     */
    @Select("SELECT * FROM user_login_valid WHERE token = #{token}")
    TokenInfo findTokenInfoByToken(@Param("token") String token);
}
