package com.xy.cola.test.example.service.impl;

import com.xy.cola.dto.Response;
import com.xy.cola.test.example.command.OrderPlaceCmd;
import com.xy.cola.test.example.command.exe.OrderPlaceCmdExe;
import com.xy.cola.test.example.service.OrderServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class OrderServiceImpl implements OrderServiceI {

    @Resource
    private OrderPlaceCmdExe orderPlaceCmdExe;

    /**
     * 下单处理
     *
     * @param orderPlaceCmd 下单指令
     * @return 处理结果
     */
    @Override
    public Response placeOrder(OrderPlaceCmd orderPlaceCmd) {
        return orderPlaceCmdExe.execute(orderPlaceCmd);
    }
}
