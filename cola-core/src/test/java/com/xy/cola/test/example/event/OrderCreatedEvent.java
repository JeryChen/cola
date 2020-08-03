package com.xy.cola.test.example.event;

import com.xy.cola.event.DomainEventI;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈订单创建完成事件〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderCreatedEvent implements DomainEventI {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 本次使用积分
     */
    private Integer useCredit;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUseCredit() {
        return useCredit;
    }

    public void setUseCredit(Integer useCredit) {
        this.useCredit = useCredit;
    }
}
