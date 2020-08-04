package com.xy.cola.event;

import com.xy.cola.dto.Response;
import com.xy.cola.exception.ColaException;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈事件控制中枢〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class EventHub {

    /**
     * 事件处理器注册库容器
     */
    private HashMap<Class, List<EventHandlerI>> eventRepository = new HashMap<>();

    /**
     * 事件响应结果注册库容器
     */
    private Map<Class, Response> responseRepository = new HashMap<>();

    /**
     * 获取事件处理器
     *
     * @param eventClass 事件
     * @return 事件处理器
     */
    public List<EventHandlerI> getEventHandler(Class eventClass) {
        List<EventHandlerI> eventHandlerIList = eventRepository.get(eventClass);
        if (CollectionUtils.isEmpty(eventHandlerIList)) {
            throw new ColaException(eventClass + "is not registered in eventHub, please register first.");
        }
        return eventHandlerIList;
    }

    /**
     * 注册事件
     *
     * @param eventClz 事件
     * @param executor 事件处理器
     */
    public void register(Class<? extends EventI> eventClz, EventHandlerI executor) {
        List<EventHandlerI> eventHandlers = eventRepository.get(eventClz);
        if (eventHandlers == null) {
            eventHandlers = new ArrayList<>();
            eventRepository.put(eventClz, eventHandlers);
        }
        eventHandlers.add(executor);
        AnnotationAwareOrderComparator.sort(eventHandlers);
    }

    /**
     * 获取事件处理结果
     * 主要用于事件处理异常，采用自定义响应结果
     *
     * @param eventClass 事件
     * @return 处理结果
     */
    public Response getEventResponse(Class eventClass) {
        return responseRepository.get(eventClass);
    }

    /**
     * 注册事件处理结果
     * 主要用于事件处理异常，采用自定义响应结果
     *
     * @param eventClz 事件
     * @param response 自定义处理结果
     */
    public void register(Class<? extends EventI> eventClz, Response response) {
        Response eventResponse = getEventResponse(eventClz);
        if (eventResponse == null) {
            responseRepository.put(eventClz, response);
        }
    }

}
