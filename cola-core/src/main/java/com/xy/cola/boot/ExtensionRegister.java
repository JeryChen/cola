package com.xy.cola.boot;

import com.xy.cola.common.ColaConstant;
import com.xy.cola.exception.ColaException;
import com.xy.cola.extension.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈扩展点注册器〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class ExtensionRegister {

    @Resource
    private ExtensionRepository extensionRepository;

    /**
     * 扩展点注册
     *
     * @param extensionObject 扩展点
     */
    public void register(ExtensionPointI extensionObject) {
        Class<?> extensionClz = extensionObject.getClass();
        Extension extensionAnn = extensionClz.getDeclaredAnnotation(Extension.class);
        BizScenario bizScenario = BizScenario.valueOf(extensionAnn.bizId(), extensionAnn.useCase(), extensionAnn.scenario());
        ExtensionCoordinate extensionCoordinate = new ExtensionCoordinate(calculateExtensionPoint(extensionClz), bizScenario.getUniqueIdentity());
        extensionRepository.register(extensionCoordinate, extensionObject);
    }

    /**
     * 计算扩展点名
     *
     * @param targetClz 扩展点
     * @return 扩展点名
     */
    private String calculateExtensionPoint(Class<?> targetClz) {
        Class[] interfaces = targetClz.getInterfaces();
        if (interfaces == null || interfaces.length == 0) {
            throw new ColaException("Please assign a extension point interface for " + targetClz);
        }
        for (Class intf : interfaces) {
            String extensionPoint = intf.getSimpleName();
            if (extensionPoint.contains(ColaConstant.EXTENSION_EXTPT_NAMING)) {
                return intf.getName();
            }
        }
        throw new ColaException("Your name of ExtensionPoint for " + targetClz + " is not valid, must be end of " + ColaConstant.EXTENSION_EXTPT_NAMING);
    }
}
