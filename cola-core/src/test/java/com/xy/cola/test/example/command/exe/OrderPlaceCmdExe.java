package com.xy.cola.test.example.command.exe;

import com.xy.cola.dto.Response;
import com.xy.cola.extension.ExtensionExecutor;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;
import com.xy.cola.test.example.command.OrderPlaceCmd;
import com.xy.cola.test.example.event.OrderCreatedEvent;
import com.xy.cola.test.example.event.domain.DomainEventPublisher;
import com.xy.cola.test.example.validator.extensionpoint.OrderPlaceValidatorExtPt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class OrderPlaceCmdExe {

    private static final Logger logger = LoggerFactory.getLogger(OrderPlaceCmdExe.class);

    @Resource
    private DomainEventPublisher domainEventPublisher;

    @Resource
    private ExtensionExecutor extensionExecutor;

    public Response execute(OrderPlaceCmd orderPlaceCmd) {
        logger.info("开始下单处理...，OrderPlaceCmd:" + orderPlaceCmd);
        extensionExecutor.executeVoid(OrderPlaceValidatorExtPt.class, orderPlaceCmd.getBizScenario(),
                extension -> extension.validate(orderPlaceCmd));
        logger.info("下单处理完成，OrderPlaceCmd:" + orderPlaceCmd);
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        orderCreatedEvent.setUserId(orderPlaceCmd.getOrderCO().getUserId());
        orderCreatedEvent.setUseCredit(orderPlaceCmd.getUseCredit());
        domainEventPublisher.publishAll(orderCreatedEvent);
        return Response.buildSuccess();
    }
}
