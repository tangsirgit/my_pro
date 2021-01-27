package com.my.emplogin.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : tanghuai
 * @date : 2021/1/27 11:04
 */

@HeadRowHeight(value = 35) // 表头行高
@ContentRowHeight(value = 25) // 内容行高
// @ColumnWidth(value = 50) // 列宽 在controller里可以设置自适应
@Data
public class EasyExcelTestEntity {

    @ExcelProperty(value = "id", order = 1)
    // @ExcelIgnore 指定忽略哪一栏不导出
    private Integer id;
    @ExcelProperty(value = "姓名", order = 3)
    private String userName;
    @ExcelProperty(value = "薪水", order = 2)
    private BigDecimal salary;
    @ExcelProperty(value = "生日", order = 4)
    @DateTimeFormat("yyyy-MM-dd")
    private Date birthday;
}
