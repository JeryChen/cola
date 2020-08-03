package com.xy.cola.event;

/**
 * 〈一句话介绍功能〉<br>
 * 消息队列事件接口(metaQ)
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MessageQueueEventI {

    /**
     * 获取事件类型
     *
     * @return 事件类型
     */
    String getEventType();

    /**
     * 获取事件topic
     *
     * @return 事件topic
     */
    String getEventTopic();
}
