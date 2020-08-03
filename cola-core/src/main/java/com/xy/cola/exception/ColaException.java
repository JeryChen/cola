package com.xy.cola.exception;

import com.xy.cola.dto.ErrorCodeI;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈Infrastructure Exception〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ColaException extends BaseException {

    private static final long serialVersionUID = 1L;

    public ColaException(String errMessage) {
        super(errMessage);
        this.setErrCode(BasicErrEnum.COLA_ERROR);
    }

    public ColaException(String errMessage, Throwable e) {
        super(errMessage, e);
        this.setErrCode(BasicErrEnum.COLA_ERROR);
    }

    public ColaException(ErrorCodeI errCode, String errMessage) {
        super(errMessage);
        this.setErrCode(errCode);
    }
}
