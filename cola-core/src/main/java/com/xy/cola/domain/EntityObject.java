package com.xy.cola.domain;

import com.xy.cola.extension.BizScenario;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈实体对象〉
 * 所有域对象的父对象
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class EntityObject {

    /**
     * 业务场景
     */
    private BizScenario bizScenario;

    public BizScenario getBizScenario() {
        return bizScenario;
    }

    public void setBizScenario(BizScenario bizScenario) {
        this.bizScenario = bizScenario;
    }

}
