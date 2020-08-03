package com.xy.cola.dto;

import com.xy.cola.extension.BizScenario;

/**
 * 〈一句话介绍功能〉<br>
 * <p>
 * 命令代表来自客户端的请求。根据CommandExecutor将有助于处理业务逻辑。这是经典的命令模式
 * 主要参考CQRS概念
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class Command extends DTO {

    private static final long serialVersionUID = 1L;

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
