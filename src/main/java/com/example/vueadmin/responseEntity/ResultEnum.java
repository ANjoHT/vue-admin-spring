package com.example.vueadmin.responseEntity;

import lombok.Getter;

@Getter
public enum ResultEnum {
    OK(true, 200, "成功"),
    CREATED(true, 201, "成功"),
    NO_CONTENT(true, 204, "成功"),
    BAD_REQUEST(true, 400, "参数错误"),
    UNAUTHORIZED(true, 401, "用户名或密码错误"),
    TOKEN(true, 403, "未授权,请登录"),
    NOT_FOUND(true, 404, "找不到请求的资源");

    private Boolean success;
    private Integer code;
    private String message;

    ResultEnum(Boolean success,Integer code,String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
