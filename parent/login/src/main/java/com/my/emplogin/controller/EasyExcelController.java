package com.my.emplogin.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.my.emplogin.config.EasyExcelListener;
import com.my.emplogin.entity.EasyExcelTestEntity;
import com.my.emplogin.model.SheetOneTestModel;
import com.my.emplogin.model.SheetSecondTestModel;
import com.my.emplogin.service.EasyExcelService;
import com.my.emplogin.vo.req.ExportPrivateReqVO;
import com.my.emplogin.vo.res.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : tanghuai
 * @date : 2021/1/27 11:03
 */
@Api(tags = {"EasyExcel导出测试"})
@Data
@Slf4j
@RestController
@RequestMapping("/easyExcel")
public class EasyExcelController {

    @Resource
    private EasyExcelService service;

    @GetMapping("/exportPrivate")
    @ApiOperation("导出excel")
    public void exportPrivate(/*@Valid @RequestBody*/ ExportPrivateReqVO vo, HttpServletResponse response) {
        log.info(vo.getFileName());
        service.exportPrivate(vo, response);
    }

    @GetMapping("readEasyExcel")
    @ApiOperation("读取excel")
    public void importPrivate(String filePath) {
        String fileName = "D:\\mybrowser\\google\\" + "私募基金.xlsx";
        EasyExcel.read(fileName, EasyExcelTestEntity.class, new EasyExcelListener()).sheet().doRead();
    }

    @PostMapping("/webRead")
    @ApiOperation("web中读取excel")
    public ResponseVO<String> webReadExcel(MultipartFile file) throws IOException {
        List<SheetOneTestModel> l1 = new ArrayList<>();
        List<SheetSecondTestModel> l2 = new ArrayList<>();
        ExcelReader build = EasyExcel.read(file.getInputStream()).build();
        ReadSheet s1 = EasyExcel.readSheet(0).head(SheetOneTestModel.class).registerReadListener(new AnalysisEventListener<SheetOneTestModel>() {
            @Override
            public void invoke(SheetOneTestModel o, AnalysisContext analysisContext) {
                l1.add(o);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).build();
        ReadSheet s2 = EasyExcel.readSheet(1).head(SheetSecondTestModel.class).registerReadListener(new AnalysisEventListener<SheetSecondTestModel>() {
            @Override
            public void invoke(SheetSecondTestModel o, AnalysisContext analysisContext) {
                l2.add(o);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).build();
        build.read(s1, s2);
        if (build != null) {
            build.finish();
        }

        l1.forEach(System.out::println);
        l2.forEach(System.out::println);
        return new ResponseVO<>("导入成功");
    }
}
