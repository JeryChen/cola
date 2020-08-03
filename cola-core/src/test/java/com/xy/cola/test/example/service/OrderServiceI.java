package com.xy.cola.test.example.service;

import com.xy.cola.dto.Response;
import com.xy.cola.test.example.command.OrderPlaceCmd;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈订单服务〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface OrderServiceI {

    /**
     * 下单处理
     *
     * @param orderPlaceCmd 下单指令
     * @return 处理结果
     */
    Response placeOrder(OrderPlaceCmd orderPlaceCmd);
}
