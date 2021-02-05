package com.my.emplogin.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.OnceAbsoluteMerge;
import com.alibaba.excel.converters.string.StringImageConverter;
import lombok.Data;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * 图片导出实体
 *
 * @author : tanghuai
 * @date : 2021/2/4 9:38
 */
@Data
@ContentRowHeight(100)
@ColumnWidth(100 / 8)
// 将第2-3行的5-6列合并成一个单元格
@OnceAbsoluteMerge(firstRowIndex = 1, lastRowIndex = 2, firstColumnIndex = 4, lastColumnIndex = 5)
public class ImageModel {
    private File file;
    private InputStream inputStream;
    /**
     * 如果是string类型，必须指定转换器，String默认转换为String
     */
    @ExcelProperty(value = {"表头", "图片1"}, converter = StringImageConverter.class)
    private String string;
    @ExcelProperty(value = {"表头", "图片2"})
    private byte[] byteArray;

    /**
     * 根据url导出
     */
    @ExcelProperty(value = "url")
    private URL url;

}
