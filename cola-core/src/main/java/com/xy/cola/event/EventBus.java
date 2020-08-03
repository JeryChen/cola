package com.xy.cola.event;

import com.xy.cola.dto.ErrorCodeI;
import com.xy.cola.dto.Response;
import com.xy.cola.exception.BaseException;
import com.xy.cola.exception.BasicErrEnum;
import com.xy.cola.exception.ColaException;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈事件总线〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class EventBus implements EventBusI {

    private static final Logger logger = LoggerFactory.getLogger(EventBus.class);

    /**
     * 默认线程池
     * 如果处理器无定制线程池，则使用此默认
     */
    ExecutorService defaultExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1,
            Runtime.getRuntime().availableProcessors() + 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1000));

    @Resource
    private EventHub eventHub;


    /**
     * 触发事件总线中单个注册事件处理器
     *
     * @param event 事件
     */
    @Override
    public void fire(EventI event) {
        fireWithResponse(event);
    }

    /**
     * 触发事件总线中所有注册事件处理器
     *
     * @param event 事件
     */
    @Override
    public void fireAll(EventI event) {
        fireAllWithResponse(event);
    }

    /**
     * 触发事件总线中单个注册事件处理器
     *
     * @param event 事件
     * @return 响应结果
     */
    @Override
    public Response fireWithResponse(EventI event) {
        Response response = null;
        EventHandlerI eventHandlerI = null;
        try {
            eventHandlerI = eventHub.getEventHandler(event.getClass()).get(0);
            response = eventHandlerI.execute(event);
        } catch (Exception exception) {
            response = handleException(eventHandlerI, response, exception);
        }
        return response;
    }

    /**
     * 触发事件总线中所有注册事件处理器
     *
     * @param event 事件
     * @return 响应结果
     */
    @Override
    public List<Response> fireAllWithResponse(EventI event) {
        return eventHub.getEventHandler(event.getClass()).stream().map(p -> {
            Response response = null;
            try {
                response = p.execute(event);
            } catch (Exception exception) {
                response = handleException(p, response, exception);
            }
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 异步触发事件总线中单个注册事件处理器
     *
     * @param event 事件
     */
    @Override
    public void asyncFire(EventI event) {
        asyncFireWithResponse(event);
    }

    /**
     * 异步触发事件总线中所有注册事件处理器
     *
     * @param event 事件
     */
    @Override
    public void asyncFireAll(EventI event) {
        asyncFireAllWithResponse(event);
    }

    /**
     * 异步触发事件总线中单个注册事件处理器
     *
     * @param event 事件
     * @return 响应结果
     */
    @Override
    public Response asyncFireWithResponse(EventI event) {
        Response response = null;
        EventHandlerI eventHandlerI = null;
        try {
            eventHandlerI = eventHub.getEventHandler(event.getClass()).get(0);
            EventHandlerI finalEventHandlerI = eventHandlerI;
            if (null != finalEventHandlerI.getExecutor()) {
                eventHandlerI.getExecutor().submit(() -> finalEventHandlerI.execute(event));
            } else {
                defaultExecutor.submit(() -> finalEventHandlerI.execute(event));
            }
        } catch (Exception exception) {
            response = handleException(eventHandlerI, response, exception);
        }
        return response;
    }

    /**
     * 异步触发事件总线中所有注册事件处理器
     *
     * @param event 事件
     * @return 响应结果
     */
    @Override
    public List<Response> asyncFireAllWithResponse(EventI event) {
        return eventHub.getEventHandler(event.getClass()).parallelStream().map(p -> {
            Response response = null;
            try {
                if (null != p.getExecutor()) {
                    p.getExecutor().submit(() -> p.execute(event));
                } else {
                    defaultExecutor.submit(() -> p.execute(event));
                }
            } catch (Exception exception) {
                response = handleException(p, response, exception);
            }
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 事件异常处理
     *
     * @param handler   事件处理器
     * @param response  响应结果
     * @param exception 异常
     * @return 响应结果
     */
    private Response handleException(EventHandlerI handler, Response response, Exception exception) {
        logger.error(exception.getMessage(), exception);
        try {
            response = null != eventHub.getEventResponse(handler.getClass()) ? response : new Response();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ColaException(e.getMessage());
        }
        if (exception instanceof BaseException) {
            ErrorCodeI errCode = ((BaseException) exception).getErrCode();
            response.setCode(errCode.getErrCode());
        } else {
            response.setCode(BasicErrEnum.SYS_ERROR.getErrCode());
        }
        response.setMessage(exception.getMessage());
        return response;
    }
}
