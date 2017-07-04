package com.shmily.exception;

import com.shmily.support.common.Response;
import com.shmily.support.common.ResponseUtil;
import com.shmily.support.enums.StateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如果使用了@Validated，那么BeanValidate也会抛出异常而不是之前的封装在BindingResult中,所以目前在这里同意处理
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
            return ResponseUtil.error(StateEnum.SYS_ERROR);
        }
    }

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseBody
    public Response ValidException(ConstraintViolationException e){
        Map<Integer, String > map = new HashMap<>();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        //StringBuilder strBuilder = new StringBuilder();
        AtomicInteger count = new AtomicInteger(1);
        for (ConstraintViolation<?> violation : violations ) {
            map.put(count.addAndGet(1),violation.getMessage());
        }
        return ResponseUtil.error(StateEnum.PRAMS_ERROR,map);
    }
}
