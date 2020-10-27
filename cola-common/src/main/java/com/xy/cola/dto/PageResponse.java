package com.xy.cola.dto;

import com.xy.cola.common.PagingParam;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2020/10/27.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PageResponse<T> extends SingleResponse<T> {

    /**
     * 分页信息
     */
    private PagingParam pagingParam;

    /**
     * 构建成功响应结果
     *
     * @param data        处理结果对象
     * @param <T>         泛型对象
     * @param pagingParam 分页信息
     * @return 响应结果
     */
    public static <T> PageResponse<T> of(T data, PagingParam pagingParam) {
        PageResponse<T> response = new PageResponse<>();
        response.setSuccess(true);
        response.setData(data);
        response.setPagingParam(pagingParam);
        return response;
    }

    public PagingParam getPagingParam() {
        return pagingParam;
    }

    public void setPagingParam(PagingParam pagingParam) {
        this.pagingParam = pagingParam;
    }
}
