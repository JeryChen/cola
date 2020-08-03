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
public enum BasicErrEnum implements ErrorCodeI {

    /**
     * 三个基础异常
     * <p>
     * BIZ_ERROR
     * COLA_ERROR
     * SYS_ERROR
     */
    BIZ_ERROR("BIZ_ERROR", "通用的业务逻辑错误"),

    COLA_ERROR("COLA_ERROR", "COLA框架错误"),

    SYS_ERROR("SYS_ERROR", "未知的系统错误");

    /**
     * 错误码
     */
    private String errCode;

    /**
     * 错误描述
     */
    private String errDesc;

    BasicErrEnum(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    /**
     * 获取错误码
     *
     * @return
     */
    @Override
    public String getErrCode() {
        return errCode;
    }

    /**
     * 获取错误描述
     *
     * @return
     */
    @Override
    public String getErrDesc() {
        return errDesc;
    }
}
