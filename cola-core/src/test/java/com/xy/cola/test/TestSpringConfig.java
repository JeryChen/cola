package com.xy.cola.test;

import com.xy.cola.boot.SpringBootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈spring测试配置〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
@ComponentScan(value = {"com.xy.cola","com.xy.cola.test"})
@PropertySource(value = {"/sample.properties"})
public class TestSpringConfig {

    @Bean(initMethod = "init")
    public SpringBootstrap bootstrap() {
        return new SpringBootstrap();
    }
}
