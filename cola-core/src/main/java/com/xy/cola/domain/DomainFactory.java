package com.xy.cola.domain;

import com.xy.cola.common.ApplicationContextHandler;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈领域工厂〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DomainFactory {

    /**
     * 获取实体对象
     *
     * @param entityClz 实体对象
     * @param <T>       实体对象类型
     * @return 域对象
     */
    public static <T extends EntityObject> T getBean(Class<T> entityClz) {
        return ApplicationContextHandler.getBean(entityClz);
    }
}
