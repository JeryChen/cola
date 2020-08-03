package com.xy.cola.filter;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈过滤器接口〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Filter<T> {

    /**
     * 过滤处理
     *
     * @param context    场景对象
     * @param nextFilter 过滤器调用者
     */
    void doFilter(T context, FilterInvoker nextFilter);

}
