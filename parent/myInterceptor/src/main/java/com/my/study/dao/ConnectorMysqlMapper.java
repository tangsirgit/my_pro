package com.my.study.dao;

import com.my.study.entity.TestEntity;

import com.my.study.excel.enetity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author : admin
 * @date : 2021/1/7 15:22
 */
@Mapper
public interface ConnectorMysqlMapper {
    /**
     * 测试-获取数据库信息
     * @return
     */
    @Select("SELECT * FROM test WHERE id = 1")
    TestEntity getTestEntity();


    /**
     * 获取excel
     * @return
     */
    @Select("SELECT * FROM easypoi_test_table ")
    List<Person> getExcelEntity();
}
