package com.my.study.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : tanghuai
 * @date : 2021/1/11 11:31
 */
@ApiModel(value = "LoginReqVo",description = "登录请求体")
@Data
public class LoginReqVo {
    @ApiModelProperty("用户名")
    private String userName;
}
