package com.my.emplogin.service.impl;

import com.my.emplogin.dao.EasyExcelMapper;
import com.my.emplogin.entity.EasyExcelPrivateDO;
import com.my.emplogin.service.EasyExcelService;
import com.my.emplogin.util.EasyExcelUtil;
import com.my.emplogin.vo.req.ExportPrivateReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author : tanghuai
 * @date : 2021/1/27 13:39
 */
@Service
@Slf4j
public class EasyExcelServiceImpl implements EasyExcelService {
    @Resource
    private EasyExcelMapper mapper;

    @Override
    public void exportPrivate(ExportPrivateReqVO vo, HttpServletResponse response) {
        List<EasyExcelPrivateDO> easyExcelPrivateDOS = mapper.exportPrivate();

       /* // 生成本地
        EasyExcel.write("私募基金"+ ExcelTypeEnum.XLSX.getValue(),EasyExcelPrivateDO.class)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet(0,"私募基金")
                .doWrite(easyExcelPrivateDOS);*/
        try {
            EasyExcelUtil.export2Web(response, vo.getFileName(), "私募基金", EasyExcelPrivateDO.class, easyExcelPrivateDOS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
