package com.xy.cola.test.example.co;

import com.xy.cola.dto.ClientObject;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈积分客户端对象〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CreditCO extends ClientObject {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 积分
     */
    private Integer credit;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
