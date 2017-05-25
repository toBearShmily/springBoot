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

    public static Response error(StateEnum stateEnum){
        return new Response(stateEnum,null);
    }
}
