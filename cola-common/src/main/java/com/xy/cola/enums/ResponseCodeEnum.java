package com.xy.cola.enums;

/**
 * <功能介绍><br>
 * <p>
 * <响应码枚举>
 * #################################################
 * # 分类	# 描述                                  #
 * # 1xx	# 信息，服务器收到请求，需要请求者继续执行操作  #
 * # 2xx	# 成功                                  #
 * # 3xx	# 重定向，需要进一步的操作以完成请求          #
 * # 4xx	# 客户端错误，请求包含语法错误或无法完成请求   #
 * # 5xx	# 服务端错误                             #
 * #################################################
 *
 * @author xy on 2020/10/30.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum ResponseCodeEnum {

    /**
     * 响应码
     */
    SUCCESS_200("200", "处理成功"),

    FAIL_PARAMS_401("401", "请求参数格式不正确"),

    FAIL_SYS_500("500", "未知系统处理失败"),
    FAIL_BIZ_501("501", "业务处理失败");

    private final String code;

    private final String desc;

    ResponseCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
