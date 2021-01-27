package com.my.emplogin.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


/**
 * @author : tanghuai
 * @date : 2021/1/12 20:53
 */
@Data
@ApiModel(value = "LoginReqVO",description = "登录请求体")
public class LoginReqVO {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userId;

    @ApiModelProperty("用户密码")
    @NotBlank(message = "用户密码不能为空")
    private String password;

    @ApiModelProperty("验证码")
    @NotBlank(message = "验证码不能为空")
    private String verifyCode;
}
