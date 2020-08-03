package com.xy.cola.test.filter;

import com.xy.cola.extension.BizScenario;
import com.xy.cola.filter.Filter;
import com.xy.cola.filter.FilterChain;
import com.xy.cola.filter.FilterChainFactory;
import com.xy.cola.test.BaseTest;
import com.xy.cola.test.example.co.OrderCO;
import com.xy.cola.test.example.command.OrderPlaceCmd;
import com.xy.cola.test.example.constants.BizConstants;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FilterChainTest extends BaseTest {

    @Resource
    private Filter orderStatusFilter;

    @Resource
    private Filter orderUserIdFilter;

    @Test
    public void testFilterChain() {
        FilterChain<Object> objectFilterChain = FilterChainFactory.buildFilterChain(orderStatusFilter.getClass(),
                orderUserIdFilter.getClass());
        OrderPlaceCmd orderPlaceCmd = new OrderPlaceCmd();
        OrderCO orderCO = new OrderCO();
        orderCO.setGoodsId(1);
        orderCO.setOrderNo("DT001");
        orderCO.setOrderStatus(1);
        orderCO.setPayment(new BigDecimal(20));
        orderCO.setUserId(1);
        orderPlaceCmd.setOrderCO(orderCO);
        BizScenario scenario = BizScenario.valueOf(BizConstants.PLACE_ORDER_BIZ_ID);
        orderPlaceCmd.setBizScenario(scenario);
        orderPlaceCmd.setUseCredit(10);
        objectFilterChain.doFilter(orderPlaceCmd);
    }
}
