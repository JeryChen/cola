package com.xy.cola.exception;

import com.xy.cola.common.ApplicationContextHandler;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈异常处理器工厂〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ExceptionHandlerFactory {

    /**
     * 获取异常处理器
     *
     * @return 异常处理器
     */
    public static ExceptionHandlerI getExceptionHandler() {
        try {
            return ApplicationContextHandler.getBean(ExceptionHandlerI.class);
        } catch (NoSuchBeanDefinitionException ex) {
            return DefaultExceptionHandler.singleton;
        }
    }
}
