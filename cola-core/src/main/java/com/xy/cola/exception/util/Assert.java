package com.xy.cola.exception.util;

import com.xy.cola.dto.ErrorCodeI;
import com.xy.cola.exception.BasicErrEnum;
import com.xy.cola.exception.BizException;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈断言工具类〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class Assert {

    /**
     * Assert a boolean expression, throwing {@code BizException}
     * <p>
     * for example
     *
     * <pre class="code">Assert.isTrue(i != 0, errorCode.B_ORDER_illegalNumber, "The order number can not be zero");</pre>
     *
     * @param expression a boolean expression
     * @param errorCode
     * @param message    the exception message to use if the assertion fails
     * @throws BizException if expression is {@code false}
     */
    public static void isTrue(boolean expression, ErrorCodeI errorCode, String message) {
        if (!expression) {
            throw new BizException(errorCode, message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        isTrue(expression, BasicErrEnum.BIZ_ERROR, message);
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    public static void notNull(Object object, ErrorCodeI errorCode, String message) {
        if (object == null) {
            throw new BizException(errorCode, message);
        }
    }

    public static void notNull(Object object, String message) {
        notNull(object, BasicErrEnum.BIZ_ERROR, message);
    }

    public static void notNull(Object object) {
        notNull(object, BasicErrEnum.BIZ_ERROR, "[Assertion failed] - the argument " + object + " must not be null");
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection,
                "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BizException(message);
        }
    }

    public static void notEmpty(Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new BizException(message);
        }
    }

    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }
}
