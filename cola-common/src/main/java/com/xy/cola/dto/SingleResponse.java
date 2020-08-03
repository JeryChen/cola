package com.xy.cola.dto;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈单个记录的响应返回〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SingleResponse<T> extends Response {

    /**
     * 处理结果对象
     */
    private T data;

    /**
     * 构建成功响应结果
     *
     * @param data 处理结果对象
     * @param <T>  泛型对象
     * @return 响应结果
     */
    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> singleResponse = new SingleResponse<>();
        singleResponse.setSuccess(true);
        singleResponse.setData(data);
        return singleResponse;
    }

    /**
     * 构建失败理响应结果
     *
     * @param code    响应码
     * @param message 描述
     * @return 响应结果
     */
    public static SingleResponse buildFailure(String code, String message) {
        SingleResponse response = new SingleResponse();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    /**
     * 构建成功响应结果
     *
     * @return 响应结果
     */
    public static SingleResponse buildSuccess() {
        SingleResponse response = new SingleResponse();
        response.setSuccess(true);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
