package com.xy.cola.test.example.command;

import com.xy.cola.dto.Command;
import com.xy.cola.test.example.co.OrderCO;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈下单指令〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderPlaceCmd extends Command {

    /**
     * 订单信息
     */
    private OrderCO orderCO;

    /**
     * 使用积分
     */
    private Integer useCredit;

    public OrderCO getOrderCO() {
        return orderCO;
    }

    public void setOrderCO(OrderCO orderCO) {
        this.orderCO = orderCO;
    }

    public Integer getUseCredit() {
        return useCredit;
    }

    public void setUseCredit(Integer useCredit) {
        this.useCredit = useCredit;
    }

    @Override
    public String toString() {
        return "OrderPlaceCmd{" +
                "orderCO=" + orderCO +
                ", useCredit=" + useCredit +
                '}';
    }
}
