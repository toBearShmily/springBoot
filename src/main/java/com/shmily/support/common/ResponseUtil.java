package com.shmily.support.common;

import com.shmily.support.enums.StateEnum;

/**
 * 公共返回的封装
 * Created by wuxubiao on 2017/5/25.
 */
public class ResponseUtil {
    public static Response success(Object data){
        return new Response(StateEnum.SUCCESS,data);
    }

    public static Response success(){
        return success(null);
    }

    public static Response success(StateEnum stateEnum, Object data){
        return new Response(stateEnum,data);
    }

    public static Response error(StateEnum stateEnum){
        return new Response(stateEnum,null);
    }

    /**
     * 供参数校验调用
     * @param stateEnum
     * @param data
     * @return
     */
    public static Response error(StateEnum stateEnum, Object data){
        return new Response(stateEnum,data);
    }

    /**
     * 返回自定义的异常状态和信息
     * @param retCode
     * @param retDesc
     * @return
     */
    public static Response error(String retCode, String retDesc){
        return new Response(retCode,retDesc,null);
    }

    /**
     * 快捷返回，返回系统异常，用于不可解决的错误，需要开发人员
     * @return
     */
    public static Response error(){
        return error(StateEnum.SYS_ERROR);
    }
}
