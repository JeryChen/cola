package com.xy.cola.test.example.event;

import com.xy.cola.dto.Response;
import com.xy.cola.event.EventHandler;
import com.xy.cola.event.EventHandlerI;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;
import com.xy.cola.test.example.command.CreditReduceCmd;
import com.xy.cola.test.example.service.CreditServiceI;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈订单创建完成，扣减积分事件处理器〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EventHandler
@Order(1)
public class OrderCreatedForCreditReduceEventHandler implements EventHandlerI<Response, OrderCreatedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(OrderCreatedForCreditReduceEventHandler.class);

    @Resource
    private CreditServiceI creditServiceI;

    /**
     * 执行处理事件
     *
     * @param event 事件
     * @return 处理结果
     */
    @Override
    public Response execute(OrderCreatedEvent event) {
        logger.info("测试下执行器的排序，我是：OrderCreatedForCreditReduceEventHandler");
        CreditReduceCmd creditReduceCmd = new CreditReduceCmd();
        creditReduceCmd.setUserId(event.getUserId());
        creditReduceCmd.setUseCredit(event.getUseCredit());
        return creditServiceI.reduceCredit(creditReduceCmd);
    }
}
