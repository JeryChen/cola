package com.xy.cola.test.example.event;

import com.xy.cola.dto.Response;
import com.xy.cola.event.EventHandler;
import com.xy.cola.event.EventHandlerI;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈〉
 *
 * @author xingyi on 2020/8/4.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EventHandler
@Order(2)
public class OrderCreateForShippingEventHandler implements EventHandlerI<Response, OrderCreatedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(OrderCreateForShippingEventHandler.class);


    /**
     * 执行处理事件
     *
     * @param event 事件
     * @return 处理结果
     */
    @Override
    public Response execute(OrderCreatedEvent event) {
        logger.info("测试下执行器的排序，我是：OrderCreateForShippingEventHandler");
        return null;
    }
}
