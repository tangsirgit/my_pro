package com.my.emplogin.dao;

import com.my.emplogin.entity.EasyExcelPrivateDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : tanghuai
 * @date : 2021/1/27 13:37
 */
@Mapper
public interface EasyExcelMapper {

    /**
     * 测试导出私募基金
     *
     * @return
     */
    @Select("SELECT * FROM tf_test.product_center_all_market_private_fund")
    List<EasyExcelPrivateDO> exportPrivate();
}
