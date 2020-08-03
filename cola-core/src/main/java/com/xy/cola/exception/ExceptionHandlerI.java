package com.xy.cola.exception;

import com.xy.cola.dto.Command;
import com.xy.cola.dto.Response;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈异常处理器接口〉
 * 应用程序可以覆盖默认的异常处理
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ExceptionHandlerI {

    /**
     * 处理异常
     *
     * @param command   指令
     * @param response  响应结果
     * @param exception 异常
     */
    void handleException(Command command, Response response, Exception exception);
}
