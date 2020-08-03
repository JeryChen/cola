package com.xy.cola.extension;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈扩展点实现类注解扫描器〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface Extension {

    /**
     * 设置业务id
     *
     * @return 业务id
     */
    String bizId() default BizScenario.DEFAULT_BIZ_ID;

    /**
     * 设置用例
     *
     * @return 用例
     */
    String useCase() default BizScenario.DEFAULT_USE_CASE;

    /**
     * 设置场景
     *
     * @return 场景
     */
    String scenario() default BizScenario.DEFAULT_SCENARIO;
}
