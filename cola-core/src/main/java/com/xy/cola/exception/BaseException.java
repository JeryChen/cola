package com.xy.cola.exception;

import com.xy.cola.dto.ErrorCodeI;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈基础异常〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ErrorCodeI errCode;

    public BaseException(String errMessage){
        super(errMessage);
    }

    public BaseException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public ErrorCodeI getErrCode() {
        return errCode;
    }

    public void setErrCode(ErrorCodeI errCode) {
        this.errCode = errCode;
    }
}
