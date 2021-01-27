package com.my.study.service.impl;

import com.my.study.dao.ConnectorMysqlMapper;
import com.my.study.entity.TestEntity;

import com.my.study.excel.enetity.Person;
import com.my.study.service.ConnectorTestService;
import com.my.study.vo.LoginReqVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : tanghuai
 * @date : 2021/1/7 16:02
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ConnectorTestServiceImpl implements ConnectorTestService {
    @Resource
    private ConnectorMysqlMapper mapper;
    @Override
    public TestEntity getTestEntity() {
        return mapper.getTestEntity();
    }

    @Override
    public List<Person> getExcelEntity() {
        return mapper.getExcelEntity();
    }

    @Override
    public void doLogin(HttpServletRequest request, String userName) {
        HttpSession session = request.getSession();
        session.setAttribute("token",userName);
    }
}
