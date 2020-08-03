package com.xy.cola.boot;

import com.xy.cola.common.ApplicationContextHandler;
import com.xy.cola.event.EventHandler;
import com.xy.cola.event.EventHandlerI;
import com.xy.cola.extension.Extension;
import com.xy.cola.extension.ExtensionPointI;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈SpringBootstrap 启动加载配置类〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SpringBootstrap {

    @Resource
    private ExtensionRegister extensionRegister;

    @Resource
    private EventRegister eventRegister;

    public void init(){
        ApplicationContext applicationContext =  ApplicationContextHandler.getApplicationContext();
        Map<String, Object> extensionBeans = applicationContext.getBeansWithAnnotation(Extension.class);
        extensionBeans.values().forEach(
                extension -> extensionRegister.register((ExtensionPointI) extension)
        );

        Map<String, Object> eventHandlerBeans = applicationContext.getBeansWithAnnotation(EventHandler.class);
        eventHandlerBeans.values().forEach(
                eventHandler -> eventRegister.register((EventHandlerI) eventHandler)
        );
    }
}
