package com.xy.cola.event;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈事件总线接口〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface EventBusI {

    /**
     * 触发事件总线中单个注册事件处理器
     *
     * @param event 事件
     */
    void fire(EventI event);

    /**
     * 触发事件总线中所有注册事件处理器
     *
     * @param event 事件
     */
    void fireAll(EventI event);

    /**
     * 异步触发事件总线中单个注册事件处理器
     *
     * @param event 事件
     */
    void asyncFire(EventI event);

    /**
     * 异步触发事件总线中所有注册事件处理器
     *
     * @param event 事件
     */
    void asyncFireAll(EventI event);
}
