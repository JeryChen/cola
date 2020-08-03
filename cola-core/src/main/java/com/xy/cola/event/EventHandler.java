package com.xy.cola.event;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈事件处理器注释扫描器〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface EventHandler {
}
