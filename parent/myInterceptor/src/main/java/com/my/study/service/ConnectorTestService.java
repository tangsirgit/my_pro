package com.my.study.service;

import com.my.study.entity.TestEntity;
import com.my.study.excel.enetity.Person;
import com.my.study.vo.LoginReqVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 连接本地数据库测试service
 * @author : tanghuai
 * @date : 2021/1/7 15:58
 */

public interface ConnectorTestService {

    /**
     * 获取测试数据
     * @return
     */
    TestEntity getTestEntity();


    /**
     * 导出excel
     * @return
     */
    List<Person> getExcelEntity();

    /**
     * 登录
     * @param request
     * @param userId
     */
    void doLogin(HttpServletRequest request, String userId);
}
