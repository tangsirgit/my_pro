package com.my.emplogin.service;

import com.my.emplogin.vo.req.ExportPrivateReqVO;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : tanghuai
 * @date : 2021/1/27 13:39
 */
public interface EasyExcelService {

    /**
     * 导出私募
     *
     * @param vo       导出请求体
     * @param response
     */
    void exportPrivate(ExportPrivateReqVO vo, HttpServletResponse response);
}
