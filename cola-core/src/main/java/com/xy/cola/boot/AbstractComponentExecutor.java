package com.xy.cola.boot;

import com.xy.cola.extension.BizScenario;
import com.xy.cola.extension.ExtensionCoordinate;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈抽象组件执行器〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class AbstractComponentExecutor {

    /**
     * 执行扩展点任务
     *
     * @param targetClz   扩展点目标类
     * @param bizScenario 业务场景
     * @param exeFunction 函数式执行返回响应结果
     * @param <R>         响应结果类型
     * @param <T>         参数类型
     * @return 执行扩展点结果
     */
    public <R, T> R execute(Class<T> targetClz, BizScenario bizScenario, Function<T, R> exeFunction) {
        T component = locateComponent(targetClz, bizScenario);
        return exeFunction.apply(component);
    }

    /**
     * 执行扩展点任务
     *
     * @param extensionCoordinate 扩展点坐标目标类信息
     * @param exeFunction         函数式执行返回响应结果
     * @param <R>                 响应结果类型
     * @param <T>                 参数类型
     * @return 执行扩展点结果
     */
    public <R, T> R execute(ExtensionCoordinate extensionCoordinate, Function<T, R> exeFunction) {
        return execute((Class<T>) extensionCoordinate.getExtensionPointClass(), extensionCoordinate.getBizScenario(), exeFunction);
    }

    /**
     * 执行扩展点任务
     *
     * @param targetClz   扩展点目标类
     * @param bizScenario 业务场景
     * @param exeFunction 函数式执行不返回响应结果
     * @param <T>         参数类型
     */
    public <T> void executeVoid(Class<T> targetClz, BizScenario bizScenario, Consumer<T> exeFunction) {
        T component = locateComponent(targetClz, bizScenario);
        exeFunction.accept(component);
    }

    /**
     * 执行扩展点任务
     *
     * @param extensionCoordinate 扩展点坐标目标类信息
     * @param exeFunction         函数式执行不返回响应结果
     * @param <T>                 参数类型
     */
    public <T> void executeVoid(ExtensionCoordinate extensionCoordinate, Consumer<T> exeFunction) {
        executeVoid(extensionCoordinate.getExtensionPointClass(), extensionCoordinate.getBizScenario(), exeFunction);
    }

    /**
     * 查找扩展点组件
     *
     * @param targetClz   扩展点目标类
     * @param bizScenario 业务场景
     * @param <C>         参数类型
     * @return 扩展点组件
     */
    protected abstract <C> C locateComponent(Class<C> targetClz, BizScenario bizScenario);
}
