package com.xy.cola.logger;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈日志工厂〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LoggerFactory {

    private static boolean useSysLogger = false;

    public static Logger getLogger(Class<?> clazz) {
        if(useSysLogger) {
            return SysLogger.getLogger(clazz);
        }
        org.slf4j.Logger sl4jLogger = org.slf4j.LoggerFactory.getLogger(clazz);
        return new Sl4jLogger(sl4jLogger);
    }

    public static Logger getLogger(String loggerName) {
        if(useSysLogger) {
            return SysLogger.getLogger(loggerName);
        }
        org.slf4j.Logger sl4jLogger = org.slf4j.LoggerFactory.getLogger(loggerName);
        return new Sl4jLogger(sl4jLogger);
    }

    public static void activateSysLogger() {
        useSysLogger = true;
    }

    public static void deactivateSysLogger() {
        useSysLogger = false;
    }
}
