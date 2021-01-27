package com.my.emplogin.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 私募基金DO
 *
 * @author : tanghuai
 * @date : 2021/1/27 13:28
 */
@Data
public class EasyExcelPrivateDO {

    @ExcelProperty(value = "私募基金普益ID")
    @ExcelIgnore
    private Integer pyPrivateId;

    @ExcelProperty(value = "产品名称")
    private String fundName;

    @ExcelProperty(value = "备案号")
    private String recordNumber;

    @ExcelProperty(value = "基金管理人")
    private String fundManager;

    @ExcelProperty(value = "成立日")
    @DateTimeFormat("yyyy-MM-dd")
    private Date setUpDate;

    @ExcelProperty(value = "最新净值日期")
    @DateTimeFormat("yyyy-MM-dd")
    private Date netDate;

    @ExcelProperty(value = "最新净值")
    private BigDecimal netValue;

    @ExcelProperty(value = "运行时间：年")
    private BigDecimal runDate;

    @ExcelProperty(value = "运行时间类型 :1：1年以内 2： 1年-3年 3 ：3年以上")
    private Integer runType;

}
