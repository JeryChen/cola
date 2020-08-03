package com.xy.cola.boot;

import com.xy.cola.common.ColaConstant;
import com.xy.cola.event.EventHandlerI;
import com.xy.cola.event.EventHub;
import com.xy.cola.event.EventI;
import com.xy.cola.exception.ColaException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈事件注册器〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class EventRegister {

    @Resource
    private EventHub eventHub;

    /**
     * 注册事件执行器实现
     *
     * @param eventHandler 件执行器实现
     */
    public void register(EventHandlerI eventHandler) {
        Class<? extends EventI> eventClz = getEventFromExecutor(eventHandler.getClass());
        eventHub.register(eventClz, eventHandler);
    }

    /**
     * 在事件执行器实现类中获取事件
     *
     * @param eventExecutorClz 事件执行器实现类
     * @return 事件
     */
    private Class<? extends EventI> getEventFromExecutor(Class<?> eventExecutorClz) {
        Method[] methods = eventExecutorClz.getDeclaredMethods();
        for (Method method : methods) {
            if (isExecuteMethod(method)) {
                return checkAndGetEventParamType(method);
            }
        }
        throw new ColaException("Event param in " + eventExecutorClz + " " + ColaConstant.EXE_METHOD
                + "() is not detected");
    }

    /**
     * 是否是事件执行方法
     *
     * @param method 方法
     * @return 是否
     */
    private boolean isExecuteMethod(Method method) {
        return ColaConstant.EXE_METHOD.equals(method.getName()) && !method.isBridge();
    }

    /**
     * 方法检查和获取事件参数
     *
     * @param method 执行方法
     * @return 事件参数
     */
    private Class checkAndGetEventParamType(Method method) {
        Class<?>[] exeParams = method.getParameterTypes();
        if (exeParams.length == 0) {
            throw new ColaException("Execute method in " + method.getDeclaringClass() + " should at least have one parameter");
        }
        if (!EventI.class.isAssignableFrom(exeParams[0])) {
            throw new ColaException("Execute method in " + method.getDeclaringClass() + " should be the subClass of Event");
        }
        return exeParams[0];
    }
}
