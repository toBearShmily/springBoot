package com.shmily.exception;

import com.shmily.support.enums.StateEnum;

/**
 * 此处继承自RuntimeException而不是Exception的原因是保证即使抛出异常也不影响事务的回滚
 * Created by wuxubiao on 2017/5/25.
 */
public class BizException extends RuntimeException {
    private String code;

    public BizException(StateEnum stateEnum) {
        super(stateEnum.getRetDesc());
        this.code = stateEnum.getRetCode();
    }

    public BizException(String retCode, String retDesc){
        super(retDesc);
        this.code = retCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
