package com.my.emplogin.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : tanghuai
 * @date : 2021/1/27 14:32
 */
@Data
@ApiModel(value = "ExportPrivateReqVO", description = "导出请求体")
public class ExportPrivateReqVO {

    @ApiModelProperty("导出文件名称")
    private String fileName;
}
