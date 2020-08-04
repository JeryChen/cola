package com.xy.cola.test.example.event.domain;

import com.xy.cola.event.DomainEventI;
import com.xy.cola.event.EventBusI;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈域事件发布者〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class DomainEventPublisher {

    @Resource
    private EventBusI eventBus;

    /**
     * 同步处理发布
     *
     * @param domainEvent 域事件
     */
    public void publish(DomainEventI domainEvent) {
        eventBus.fire(domainEvent);
    }

    /**
     * 同步处理发布
     *
     * @param domainEvent 域事件
     */
    public void publishAll(DomainEventI domainEvent) {
        eventBus.fireAll(domainEvent);
    }

    /**
     * 异步处理发布
     *
     * @param domainEvent 域事件
     */
    public void asyncPublish(DomainEventI domainEvent) {
        eventBus.asyncFire(domainEvent);
    }

    /**
     * 异步处理发布
     *
     * @param domainEvent 域事件
     */
    public void asyncPublishAll(DomainEventI domainEvent) {
        eventBus.asyncFireAll(domainEvent);
    }
}
