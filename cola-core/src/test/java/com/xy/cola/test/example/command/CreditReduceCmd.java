package com.xy.cola.test.example.command;

import com.xy.cola.dto.Command;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈积分扣减指令〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CreditReduceCmd extends Command {

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

    @Override
    public String toString() {
        return "CreditReduceCmd{" +
                "userId=" + userId +
                ", useCredit=" + useCredit +
                '}';
    }
}
