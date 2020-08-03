package com.xy.cola.exception;

import com.xy.cola.dto.Command;
import com.xy.cola.dto.ErrorCodeI;
import com.xy.cola.dto.Response;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈默认异常处理器〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DefaultExceptionHandler implements ExceptionHandlerI {

    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    public static DefaultExceptionHandler singleton = new DefaultExceptionHandler();

    /**
     * 处理异常
     *
     * @param command   指令
     * @param response  响应结果
     * @param exception 异常
     */
    @Override
    public void handleException(Command command, Response response, Exception exception) {
        buildResponse(response, exception);
        printLog(command, response, exception);
    }

    /**
     * 打印日志
     *
     * @param cmd       指令
     * @param response  响应结果
     * @param exception 异常
     */
    private void printLog(Command cmd, Response response, Exception exception) {
        if (exception instanceof BaseException) {
            logger.warn(buildErrorMsg(cmd, response));
        } else {
            logger.error(buildErrorMsg(cmd, response), exception);
        }
    }

    /**
     * 构建异常信息
     *
     * @param cmd      指令
     * @param response 响应结果
     * @return 异常信息
     */
    private String buildErrorMsg(Command cmd, Response response) {
        return "Process [" + cmd + "] failed, errorCode: "
                + response.getCode() + " errorMsg:"
                + response.getMessage();
    }

    /**
     * 构建响应结果
     *
     * @param response  响应结果
     * @param exception 异常
     */
    private void buildResponse(Response response, Exception exception) {
        if (exception instanceof BaseException) {
            ErrorCodeI errCode = ((BaseException) exception).getErrCode();
            response.setCode(errCode.getErrCode());
        } else {
            response.setCode(BasicErrEnum.SYS_ERROR.getErrCode());
        }
        response.setMessage(exception.getMessage());
        response.setSuccess(false);
    }
}
