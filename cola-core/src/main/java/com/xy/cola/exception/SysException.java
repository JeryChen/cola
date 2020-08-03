package com.xy.cola.exception;

import com.xy.cola.dto.ErrorCodeI;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈系统异常〉
 * 意外的异常，重试可能会再次起作用
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SysException extends BaseException {

    private static final long serialVersionUID = 1L;

    public SysException(String errMessage){
        super(errMessage);
        this.setErrCode(BasicErrEnum.SYS_ERROR);
    }

    public SysException(ErrorCodeI errCode, String errMessage) {
        super(errMessage);
        this.setErrCode(errCode);
    }

    public SysException(String errMessage, Throwable e) {
        super(errMessage, e);
        this.setErrCode(BasicErrEnum.SYS_ERROR);
    }

    public SysException(String errMessage, ErrorCodeI errorCode, Throwable e) {
        super(errMessage, e);
        this.setErrCode(errorCode);
    }
}
