package com.my.emplogin;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.my.emplogin.entity.EasyExcelTestEntity;
import com.my.emplogin.entity.ImageModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author : tanghuai
 * @date : 2021/1/27 11:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class EasyExcelTest {

    // EasyExcel导出测试
    @Test
    public void testExport() {
        List<EasyExcelTestEntity> entities = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            EasyExcelTestEntity e = new EasyExcelTestEntity();
            e.setId(i);
            e.setUserName("张三" + i);
            e.setSalary(new BigDecimal(String.valueOf(i)));
            e.setBirthday(new Date());
            entities.add(e);
        }

        // 设置要导出列的属性名
        // 必须要跟类型的属性名保持一致
        Set<String> set = new HashSet<>();
        set.add("userName");
        set.add("salary");
        set.add("birthday");

        // 构建一个excel对象
        EasyExcel.write("信息表.xlsx", EasyExcelTestEntity.class)
                .includeColumnFiledNames(set)
                // 自适应宽度，不是特别精确
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet(1, "信息表")
                .doWrite(entities);

    }


    // EasyExcel 导入测试
    @Test
    public void testRead() {

        List<EasyExcelTestEntity> readList = new ArrayList<>();
        /**
         * EasyExcel 读取是基于sax方式
         * 因此在解析时需要传入监听器
         *
         * 第一个参数为 excel文件路径
         * 第二个参数读取时的数据类型
         * 第三个参数监听器
         */
        EasyExcel.read("信息表" + ExcelTypeEnum.XLSX.getValue(), new AnalysisEventListener<EasyExcelTestEntity>() {
            // 每读取一行就调用该方法
            @Override
            public void invoke(EasyExcelTestEntity o, AnalysisContext context) {
                readList.add(o);
            }

            // 全部读取完成
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("读取完成");
            }
        }).sheet(1, "信息表").doRead();
        readList.forEach(System.out::println);
    }

    /**
     * 图片导出
     */
    @Test
    public void imageWrite() throws Exception {
        String fileName = "图片" + ExcelTypeEnum.XLSX.getValue();
        InputStream inputStream = null;
        try {
            List<ImageModel> list = new ArrayList<ImageModel>();
            ImageModel imageModel = new ImageModel();
            list.add(imageModel);
            String filePath = "D:\\img.jpg";
            // 放入5种类型的图片 实际使用只要一种即可
            imageModel.setByteArray(FileUtils.readFileToByteArray(new File(filePath)));
            imageModel.setFile(new File(filePath));
            imageModel.setString(filePath);
            inputStream = FileUtils.openInputStream(new File(filePath));
            imageModel.setInputStream(inputStream);
           /* imageModel.setUrl(new URL(
                    "https://raw.githubusercontent.com/alibaba/easyexcel/master/src/test/resources/converter/img.jpg"
            ));*/
            EasyExcel.write(fileName, ImageModel.class).sheet(0, "哈哈").doWrite(list);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

        }
    }
}
