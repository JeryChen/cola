package com.xy.cola.event;

import com.xy.cola.dto.Response;

import java.util.concurrent.ExecutorService;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈事件处理器接口〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface EventHandlerI<R extends Response, E extends EventI> {

    /**
     * 获取事件处理器中自定义线程执行器
     *
     * @return 线程执行器
     */
    default ExecutorService getExecutor() {
        return null;
    }

    /**
     * 执行处理事件
     *
     * @param event 事件
     * @return 处理结果
     */
    R execute(E event);
}
