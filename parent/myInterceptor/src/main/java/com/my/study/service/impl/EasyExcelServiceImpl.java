package com.my.study.service.impl;


import com.alibaba.excel.metadata.Sheet;
import com.my.study.dao.EasyExcelMapper;
import com.my.study.entity.EasyExcelEntity;
import com.my.study.service.EasyExcelService;
import com.my.study.utils.EasyExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : tanghuai
 * @date : 2021/1/26 15:35
 */
@Service
@Slf4j
public class EasyExcelServiceImpl implements EasyExcelService {

    @Resource
    private EasyExcelMapper mapper;

    @Override
    public void getList() {
        List<EasyExcelEntity> list = mapper.getList();
        Sheet sheet = new Sheet(1,0,EasyExcelEntity.class);
        EasyExcelUtils.contextLoads("D:\\",list,sheet);
    }
}
