package com.my.emplogin.controller;

import com.my.emplogin.service.EasyExcelService;
import com.my.emplogin.vo.req.ExportPrivateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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

    @PostMapping("/exportPrivate")
    @ApiOperation("导出excel")
    public void exportPrivate(@Valid @RequestBody ExportPrivateReqVO vo, HttpServletResponse response) {
        service.exportPrivate(vo, response);
    }
}
