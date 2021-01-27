package com.my.study.dao;

import com.my.study.entity.EasyExcelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * EasyExcelMapper
 * @author : tanghuai
 * @date : 2021/1/26 15:34
 */
@Mapper
public interface EasyExcelMapper {

    /**
     * 查询私募基金列表
     * @return 私募基金列表
     */
    @Select("SELECT * FROM tf_test.product_center_all_market_private_fund limit 500")
    List<EasyExcelEntity> getList();
}
