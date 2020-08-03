package com.xy.cola.test.filter;

import com.xy.cola.filter.Filter;
import com.xy.cola.filter.FilterInvoker;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;
import com.xy.cola.test.example.command.OrderPlaceCmd;
import org.springframework.stereotype.Component;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component("orderUserIdFilter")
public class OrderUserIdFilter implements Filter<OrderPlaceCmd> {

    private static final Logger logger = LoggerFactory.getLogger(OrderUserIdFilter.class);

    /**
     * 过滤处理
     *
     * @param context    场景对象
     * @param nextFilter 过滤器调用者
     */
    @Override
    public void doFilter(OrderPlaceCmd context, FilterInvoker nextFilter) {
        logger.info("根据用户id过滤订单数据");
        nextFilter.invoke(context);
    }
}
