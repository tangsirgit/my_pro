package com.my.emplogin.vo.res;


import com.my.emplogin.enums.ResponseEnums;
import lombok.Data;

/**
 * @author : tanghuai
 * @date : 2021/1/12 9:52
 */
@Data
public class ResponseVO<T> {
    private Integer flag;
    private String message;
    private Integer errorCode;
    private T content;

    public ResponseVO() {
        this.flag = ResponseEnums.RESPONSE_CODE.SUCCESS.getCode();
        this.message = ResponseEnums.RESPONSE_CODE.SUCCESS.getName();
    }

    public ResponseVO(T content) {
        this.flag = ResponseEnums.RESPONSE_CODE.SUCCESS.getCode();
        this.message = ResponseEnums.RESPONSE_CODE.SUCCESS.getName();
        this.content = content;
    }

    public ResponseVO<T> overrideMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseVO<T> error(int errorCode, String message) {
        this.flag = ResponseEnums.RESPONSE_CODE.FAILD.getCode();
        this.errorCode = errorCode;
        this.message = message;
        return this;
    }

    public ResponseVO<T> error(String message) {
        return this.error(ResponseEnums.RESPONSE_ERROR_CODE.UNKNOWN_WARNING.getCode(), message);
    }
}
