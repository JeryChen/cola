package com.xy.cola.dto;

import com.xy.cola.enums.ResponseCodeEnum;

import java.util.Objects;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈响应结果〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Response extends DTO {

    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private boolean isSuccess;

    /**
     * 响应码
     */
    private String code;

    /**
     * 描述
     */
    private String message;

    public boolean isSuccess() {
        return isSuccess;
    }


    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 构建失败响应结果
     *
     * @param code    响应码
     * @param message 描述
     * @return 响应结果
     */
    public static Response buildFailure(String code, String message) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    /**
     * 构建失败响应结果
     *
     * @param responseCodeEnum 响应结果
     * @return 响应结果
     */
    public static Response buildFailure(ResponseCodeEnum responseCodeEnum) {
        Response response = new Response();
        response.setSuccess(false);
        if (Objects.nonNull(responseCodeEnum)) {
            response.setCode(responseCodeEnum.getCode());
            response.setMessage(responseCodeEnum.getDesc());
        }
        return response;
    }

    /**
     * 构建成功响应结果
     *
     * @return 响应结果
     */
    public static Response buildSuccess() {
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    /**
     * 构建成功响应结果
     *
     * @param message 描述
     * @return 响应结果
     */
    public static Response buildSuccess(String message) {
        Response response = new Response();
        response.setSuccess(true);
        response.setMessage(message);
        return response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "isSuccess=" + isSuccess +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
