package com.xy.cola.filter;

import com.xy.cola.common.ApplicationContextHandler;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈过滤链工厂〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FilterChainFactory {

    /**
     * 构建过滤链
     *
     * @param filterClsList 过滤器列表
     * @param <T>           泛型对象
     * @return 过滤链
     */
    public static <T> FilterChain<T> buildFilterChain(Class... filterClsList) {
        FilterInvoker last = new FilterInvoker() {
        };
        FilterChain filterChain = new FilterChain();
        for (int i = filterClsList.length - 1; i >= 0; i--) {
            FilterInvoker next = last;
            Filter filter = (Filter) ApplicationContextHandler.getBean(filterClsList[i]);
            last = new FilterInvoker<T>() {
                @Override
                public void invoke(T context) {
                    filter.doFilter(context, next);
                }
            };
        }
        filterChain.setHeader(last);
        return filterChain;
    }
}
