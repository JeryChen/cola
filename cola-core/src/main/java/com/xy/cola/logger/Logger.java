package com.xy.cola.logger;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈日志DIP〉
 * 通过依靠我们自己的日志记录器，可以轻松随意更改日志包提供商
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Logger {

    /**
     * Log a message at the DEBUG level.
     *
     * @param msg the message string to be logged
     */
    public void debug(String msg);

    /**
     * Log a message at the DEBUG level. support format.
     *
     * @param msg
     * @param args
     */
    default public void debug(String msg, Object... args) {
        debug(String.format(msg, args));
    }

    /**
     * Log a message at the INFO level.
     *
     * @param msg the message string to be logged
     */
    public void info(String msg);

    /**
     * Log a message at the INFO level. support format.
     *
     * @param msg
     * @param args
     */
    default public void info(String msg, Object... args) {
        info(String.format(msg, args));
    }

    /**
     * Log a message at the WARN level.
     *
     * @param msg the message string to be logged
     */
    public void warn(String msg);

    /**
     * Log a message at the WARN level. support format.
     *
     * @param msg
     * @param args
     */
    default public void warn(String msg, Object... args) {
        warn(String.format(msg, args));
    }

    /**
     * Log a message at the ERROR level.
     *
     * @param msg the message string to be logged
     */
    public void error(String msg);

    /**
     * Log a message at the ERROR level. support format.
     *
     * @param msg
     * @param args
     */
    default public void error(String msg, Object... args) {
        error(String.format(msg, args));
    }

    /**
     * Log an exception (throwable) at the ERROR level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    public void error(String msg, Throwable t);
}
