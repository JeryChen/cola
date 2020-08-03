package com.xy.cola.dto;

/**
 * 〈一句话介绍功能〉<br>
 * <p>
 * 通过实现此接口在业务应用程序中扩展错误代码
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ErrorCodeI {

    /**
     * 获取错误码
     *
     * @return
     */
    String getErrCode();

    /**
     * 获取错误描述
     *
     * @return
     */
    String getErrDesc();
}
