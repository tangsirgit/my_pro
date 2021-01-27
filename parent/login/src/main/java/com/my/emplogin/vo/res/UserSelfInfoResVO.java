package com.my.emplogin.vo.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户个人信息响应体
 * @author : tanghuai
 * @date : 2021/1/14 15:26
 */
@Data
@ApiModel(value = "UserSelfInfoResVO",description = "用户个人信息响应体")
public class UserSelfInfoResVO {
    @ApiModelProperty("用户id/账号")
    private String userId;
    @ApiModelProperty("用户姓名")
    private String userName;
}
