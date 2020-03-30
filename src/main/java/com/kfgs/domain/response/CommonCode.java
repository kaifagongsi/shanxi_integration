package com.kfgs.domain.response;

import lombok.ToString;

/**
 * <H3>shanxi</H3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2019-11-28 19:25
 */
@ToString
public enum CommonCode implements ResultCode {

    SUCCESS(true,10000,"操作成功"),
    FAIL(false,11111,"操作失败"),
    SERVER_ERROR(false,10002,"权限不足，无法操作"),
    INVALID_PARAM(false,10003,"非法参数");


    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;


    private CommonCode(Boolean success,int code,String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
