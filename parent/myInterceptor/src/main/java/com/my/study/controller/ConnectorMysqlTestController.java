package com.my.study.controller;
import com.my.study.excel.enetity.Person;
import com.my.study.service.ConnectorTestService;
import com.my.study.utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @author : tanghuai
 * @date : 2021/1/7 15:21
 */
@RestController
@RequestMapping("/mysqlTest")
@Api(tags = {"操作数据库-使用excelPoi导入导出"})
public class ConnectorMysqlTestController {
    private static final Logger log = LogManager.getLogger(ConnectorMysqlTestController.class);

    @Resource
    private ConnectorTestService service;

    @GetMapping("/getEntity")
    @ApiOperation("测试连接数据库")
    public String getEntity(){
        System.out.println(service.getTestEntity());
        return "操作成功";
    }

    @GetMapping("/export")
    @ApiOperation("测试导出excel")
    public void export(HttpServletResponse response){
        //模拟从数据库获取需要导出的数据
        List<Person> personList  = service.getExcelEntity();

        //导出操作
        ExcelUtils.exportExcel(personList,null,"草帽一伙",Person.class,"海贼王.xls",response);
    }

    @GetMapping("/importExcel")
    @ApiOperation("测试导入Excel")
    public void importExcel(){
        String filePath = "D:\\mybrowser\\google\\海贼王.xls";
        //解析excel，
        List<Person> personList = ExcelUtils.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        //TODO 保存数据库
    }

    @GetMapping("/login")
    @ApiOperation("登录")
    public String login(HttpServletRequest request, String userId) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        service.doLogin(request,userId);
        return "success";
    }

}
