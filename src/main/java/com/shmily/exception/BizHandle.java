package com.shmily.exception;

import com.shmily.support.common.Response;
import com.shmily.support.common.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by wuxubiao on 2017/5/25.
 */
@ControllerAdvice
public class BizHandle {

    private static Logger log = LoggerFactory.getLogger(BizHandle.class);

    @ExceptionHandler(value = Exception.class)
    public Response BizExceptionHandle(Exception e){
        if(e instanceof BizException){
            BizException biz = (BizException) e;
            return ResponseUtil.error(biz.getCode(),biz.getMessage());
        }else{
            log.error("【系统异常】{}",e);
            return ResponseUtil.error("-1","系统异常");
        }
    }
}
