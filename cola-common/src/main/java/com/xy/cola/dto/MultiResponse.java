package com.xy.cola.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈带批处理记录的响应返回〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MultiResponse<T> extends Response {

    /**
     * 处理总数
     */
    private int total;

    /**
     * 处理结果对象
     */
    private Collection<T> data;

    /**
     * 构建成功的批处理响应结果（带处理总数）
     *
     * @param data  处理结果数据对象
     * @param total 处理总数
     * @param <T>   泛型对象
     * @return 批处理结果
     */
    public static <T> MultiResponse<T> of(Collection<T> data, int total) {
        MultiResponse<T> multiResponse = new MultiResponse<>();
        multiResponse.setSuccess(true);
        multiResponse.setData(data);
        multiResponse.setTotal(total);
        return multiResponse;
    }

    /**
     * 构建成功的批处理响应结果（不带处理总数）
     *
     * @param data 处理结果数据对象
     * @param <T>  泛型对象
     * @return 批处理结果
     */
    public static <T> MultiResponse<T> ofWithoutTotal(Collection<T> data) {
        return of(data, 0);
    }

    /**
     * 构建失败批处理响应结果
     *
     * @param code    响应码
     * @param message 描述
     * @return 批处理结果
     */
    public static MultiResponse buildFailure(String code, String message) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    /**
     * 构建成功的批处理响应结果
     *
     * @return 批处理结果
     */
    public static MultiResponse buildSuccess() {
        MultiResponse response = new MultiResponse();
        response.setSuccess(true);
        return response;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return null == data ? new ArrayList<>() : new ArrayList<>(data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
