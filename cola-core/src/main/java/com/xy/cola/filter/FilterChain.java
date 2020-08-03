package com.xy.cola.filter;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈过滤链〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FilterChain<T> {

    /**
     * 过滤器调用者（第一个）
     */
    private FilterInvoker header;

    /**
     * 过滤处理
     *
     * @param context 场景对象
     */
    public void doFilter(T context) {
        header.invoke(context);
    }

    /**
     * 设置头过滤器调用者
     *
     * @param header 头过滤器调用者（第一个）
     */
    public void setHeader(FilterInvoker header) {
        this.header = header;
    }
}
