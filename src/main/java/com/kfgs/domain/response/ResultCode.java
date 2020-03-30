package com.kfgs.domain.response;

/**
 *
 */
public interface ResultCode {
    //操作是否成功，true为成功，false为失败
    boolean success();
    //操作代码
    int code();
    //提示信息
    String message();

}
