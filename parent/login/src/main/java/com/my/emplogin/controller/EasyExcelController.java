package com.my.emplogin.controller;

import com.alibaba.excel.EasyExcel;
import com.my.emplogin.config.EasyExcelListener;
import com.my.emplogin.entity.EasyExcelTestEntity;
import com.my.emplogin.service.EasyExcelService;
import com.my.emplogin.vo.req.ExportPrivateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
}
