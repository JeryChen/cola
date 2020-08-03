package com.xy.cola.domain;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈领域工厂接口〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface DomainFactoryI<T extends EntityObject> {

    /**
     * 创建领域实体对象
     *
     * @return 领域实体对象
     */
    T create();
}
