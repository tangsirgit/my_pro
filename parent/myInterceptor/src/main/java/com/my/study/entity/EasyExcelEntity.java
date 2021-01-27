package com.my.study.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 全市场私募基金数据导出实体
 * @author : tanghuai
 * @date : 2021/1/26 14:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EasyExcelEntity extends BaseRowModel {

    @ExcelProperty(value = {"私募基金普益ID"},index = 0)
    private Integer pyPrivateId;

    @ExcelProperty(value = {"产品名称"}, index = 1)
    private String fundName;

    private String recordNumber;

    @ExcelProperty(value = {"基金管理人"},index = 3)
    private String fundManager;

    @ExcelProperty(value = {"成立日"},index = 4)
    private Date setUpDate;

    @ExcelProperty(value = {"最新净值日期"},index = 5)
    private Date netDate;

    @ExcelProperty(value = {"最新净值"},index = 6)
    private BigDecimal netValue;

    @ExcelProperty(value = {"运行时间：年"},index = 7)
    private BigDecimal runDate;

    @ExcelProperty(value = {"运行时间类型"},index = 8)
    private Integer runType;


}
