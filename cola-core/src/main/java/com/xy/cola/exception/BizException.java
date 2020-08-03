package com.xy.cola.exception;

import com.xy.cola.dto.ErrorCodeI;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈业务异常〉
 * 业务处理已经知道的异常，不需要重新处理的
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BizException(String errMessage){
        super(errMessage);
        this.setErrCode(BasicErrEnum.BIZ_ERROR);
    }

    public BizException(ErrorCodeI errCode, String errMessage){
        super(errMessage);
        this.setErrCode(errCode);
    }

    public BizException(String errMessage, Throwable e) {
        super(errMessage, e);
        this.setErrCode(BasicErrEnum.BIZ_ERROR);
    }
}
