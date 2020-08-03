package com.xy.cola.test.example.service.impl;

import com.xy.cola.dto.Response;
import com.xy.cola.test.example.command.CreditReduceCmd;
import com.xy.cola.test.example.command.exe.CreditReduceCmdExe;
import com.xy.cola.test.example.service.CreditServiceI;
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
public class CreditServiceImpl implements CreditServiceI {

    @Resource
    private CreditReduceCmdExe creditReduceCmdExe;

    /**
     * 扣减积分
     *
     * @param creditReduceCmd 积分扣减指令
     * @return 处理结果
     */
    @Override
    public Response reduceCredit(CreditReduceCmd creditReduceCmd) {
        return creditReduceCmdExe.execute(creditReduceCmd);
    }
}
