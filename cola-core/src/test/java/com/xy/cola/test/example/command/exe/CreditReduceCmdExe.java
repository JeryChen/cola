package com.xy.cola.test.example.command.exe;

import com.xy.cola.dto.Response;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;
import com.xy.cola.test.example.command.CreditReduceCmd;
import org.springframework.stereotype.Component;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈积分扣减指令执行器〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class CreditReduceCmdExe {

    private static final Logger logger = LoggerFactory.getLogger(CreditReduceCmdExe.class);

    /**
     * 执行积分扣减
     *
     * @param creditReduceCmd 扣减积分指令
     * @return 处理结果
     */
    public Response execute(CreditReduceCmd creditReduceCmd) {
        logger.info("执行积分扣减操作，CreditReduceCmd：" + creditReduceCmd);
        return Response.buildSuccess();
    }

}
