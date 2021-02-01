package com.my.emplogin.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * easyExcel监听器配置
 *
 * @author : tanghuai
 * @date : 2021/2/1 9:54
 */
public class EasyExcelListener extends AnalysisEventListener {
    private static final Logger logger = LoggerFactory.getLogger(EasyExcelListener.class);

    /**
     * 每隔3000条数据读取一次
     */
    private static final int BATCH_COUNT = 3000;

    List<Object> list = new ArrayList<>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        logger.info("解析到一条数据：{}", JSON.toJSONString(o));
        list.add(o);
        System.out.println(list);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
