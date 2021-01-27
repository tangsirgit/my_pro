package com.my.emplogin.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author : tanghuai
 * @date : 2021/1/12 10:28
 */
@Data
@ApiModel(value = "RegisterReqVO",description = "注册请求体")
public class RegisterReqVO {

    @ApiModelProperty("用户名/账号")
    @NotBlank(message = "用户名不能为空")
    @Min(value = 6,message = "用户名不能少于6个字")
    @Max(value = 18,message = "用户名不能超过18个字符")
    private String userId;

    @ApiModelProperty("用户密码")
    @NotBlank(message = "用户密码不能为空")
    @Pattern(regexp = "^[0-9]{6,18}$",message = "密码必须是6~18位之间的数字")
    private String password;

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("验证码")
    @NotBlank(message = "验证码不能为空")
    private String verifyCode;

}
