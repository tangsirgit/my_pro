package com.my.study.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.my.study.entity.EasyExcelEntity;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * EasyExcel工具类
 * @author : tanghuai
 * @date : 2021/1/26 15:32
 */
public class EasyExcelUtils {


    public static void contextLoads(String filePath , List<EasyExcelEntity> list , Sheet sheet){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
            ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
            writer.write(list,sheet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
