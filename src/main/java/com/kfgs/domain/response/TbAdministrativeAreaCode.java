package com.kfgs.domain.response;

import com.kfgs.domain.response.ResultCode;
import lombok.ToString;

/**
 * <H3>shanxi</H3>
 * <p>返回代码</p>
 *
 * @author : 你的名字
 * @date : 2019-12-03 13:11
 */
@ToString
public enum  TbAdministrativeAreaCode implements ResultCode {

    ADMINISTRATIVE_AREA_CODE_FILE(false,50000,"服务器正忙");


    //操作代码
    boolean success;

    int code;
    //提示信息
    String message;

    private TbAdministrativeAreaCode(boolean success,int code,String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }


    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
