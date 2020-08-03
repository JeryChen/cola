package com.xy.cola.test.example.validator.extension;

import com.xy.cola.exception.BizException;
import com.xy.cola.extension.Extension;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;
import com.xy.cola.test.example.command.OrderPlaceCmd;
import com.xy.cola.test.example.constants.BizConstants;
import com.xy.cola.test.example.validator.extensionpoint.OrderPlaceValidatorExtPt;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈订单下单验证处理器〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Extension(bizId = BizConstants.PLACE_ORDER_BIZ_ID)
public class OrderPlaceValidatorHandler implements OrderPlaceValidatorExtPt {

    private static final Logger logger = LoggerFactory.getLogger(OrderPlaceValidatorHandler.class);

    @Override
    public void validate(OrderPlaceCmd orderPlaceCmd) {
        if (orderPlaceCmd.getUseCredit() < 0) {
            throw new BizException("使用积分不能为负数");
        }
        logger.info("订单下单验证器处理完成，OrderPlaceCmd：" + orderPlaceCmd);
    }
}
