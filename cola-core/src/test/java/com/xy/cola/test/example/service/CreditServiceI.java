package com.xy.cola.test.example.service;

import com.xy.cola.dto.Response;
import com.xy.cola.test.example.command.CreditReduceCmd;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈积分服务〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CreditServiceI {

    /**
     * 扣减积分
     *
     * @param creditReduceCmd 积分扣减指令
     * @return 处理结果
     */
    Response reduceCredit(CreditReduceCmd creditReduceCmd);
}
