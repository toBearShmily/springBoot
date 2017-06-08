package com.shmily.support.common;

import com.shmily.support.enums.StateEnum;

/**
 * 对于请求的返回数据形式做统一处理
 * Created by wuxubiao on 2017/5/25.
 */
public class Response<T> {
    private String retCode;

    private String retDesc;

    private T data;

    public Response() {
    }

    public Response(StateEnum stateEnum, T data) {
        this.retCode = stateEnum.getRetCode();
        this.retDesc = stateEnum.getRetDesc();
        this.data = data;
    }

    public Response(String retCode, String retDesc, T data) {
        this.retCode = retCode;
        this.retDesc = retDesc;
        this.data = data;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetDesc() {
        return retDesc;
    }

    public void setRetDesc(String retDesc) {
        this.retDesc = retDesc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
