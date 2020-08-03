package com.xy.cola.filter;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈过滤器调用者接口〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface FilterInvoker<T> {

    /**
     * 默认调用实现
     *
     * @param context 场景对象
     */
    default void invoke(T context) {
    }

}
