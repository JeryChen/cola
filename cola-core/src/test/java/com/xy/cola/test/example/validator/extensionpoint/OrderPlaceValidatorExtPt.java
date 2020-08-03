package com.xy.cola.test.example.validator.extensionpoint;

import com.xy.cola.extension.ExtensionPointI;
import com.xy.cola.test.example.command.OrderPlaceCmd;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈订单下单验证器〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface OrderPlaceValidatorExtPt extends ExtensionPointI {

    void validate(OrderPlaceCmd orderPlaceCmd);
}
