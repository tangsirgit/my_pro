package com.my.study.controller;

import com.my.study.service.EasyExcelService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author : tanghuai
 * @date : 2021/1/26 15:32
 */
@RestController
@RequestMapping("/EasyExcel")
@Api(tags = {"EasyExcel"})
public class EasyExcelController {
    @Resource
    private EasyExcelService service;

    @GetMapping("/easyExcel")
    public void easyExcel(){
        service.getList();
    }
}
