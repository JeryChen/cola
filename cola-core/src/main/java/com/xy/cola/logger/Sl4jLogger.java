package com.xy.cola.logger;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈slf4j logger〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Sl4jLogger implements Logger {

    private org.slf4j.Logger sl4jLogger;

    public Sl4jLogger(org.slf4j.Logger sl4jLogger) {
        this.sl4jLogger = sl4jLogger;
    }

    @Override
    public void debug(String msg) {
        sl4jLogger.debug(msg);
    }

    @Override
    public void info(String msg) {
        sl4jLogger.info(msg);

    }

    @Override
    public void warn(String msg) {
        sl4jLogger.warn(msg);

    }

    @Override
    public void error(String msg) {
        sl4jLogger.error(msg);

    }

    @Override
    public void error(String msg, Throwable t) {
        sl4jLogger.error(msg, t);
    }
}
