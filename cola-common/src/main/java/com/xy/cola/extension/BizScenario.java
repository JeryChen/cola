package com.xy.cola.extension;

/**
 * 〈一句话介绍功能〉<br>
 * BizScenario(业务场景) = bizId（业务id） + useCase（用例） + scenario（场景），标识唯一的用户业务场景
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BizScenario {

    public final static String DEFAULT_BIZ_ID = "defaultBizId";
    public final static String DEFAULT_USE_CASE = "defaultUseCase";
    public final static String DEFAULT_SCENARIO = "defaultScenario";
    private final static String DOT_SEPARATOR = ".";

    /**
     * bizId用于识别业务，如果只有一个业务，则可以为空。例如："tmall（天猫）"
     */
    private String bizId = DEFAULT_BIZ_ID;

    /**
     * 用例用于标识一个场景用例，不能为null。例如："place order（下单）"
     */
    private String useCase = DEFAULT_USE_CASE;

    /**
     * 场景用于标识一个用例的场景，不能为null。例如"88vip"，"normal"
     */
    private String scenario = DEFAULT_SCENARIO;

    /**
     * 获取唯一用户业务场景身份
     * <p>
     * 例如：用户业务场景身份可以提供"tmall.placeOrder.normal"场景以外（"tmall.placeOrder.88vip"）的扩展处理。
     *
     * @return
     */
    public String getUniqueIdentity() {
        return bizId + DOT_SEPARATOR + useCase + DOT_SEPARATOR + scenario;
    }

    /**
     * 实例自定义用户业务场景
     *
     * @param bizId    业务id
     * @param useCase  用例
     * @param scenario 场景
     * @return 用户业务场景
     */
    public static BizScenario valueOf(String bizId, String useCase, String scenario) {
        BizScenario bizScenario = new BizScenario();
        bizScenario.bizId = bizId;
        bizScenario.useCase = useCase;
        bizScenario.scenario = scenario;
        return bizScenario;
    }

    /**
     * 实例自定义业务id的用户业务场景
     *
     * @param bizId 业务id
     * @return 用户业务场景
     */
    public static BizScenario valueOf(String bizId) {
        return BizScenario.valueOf(bizId, DEFAULT_USE_CASE, DEFAULT_SCENARIO);
    }

    /**
     * 实例自定义用例 + 场景的用户业务场景
     *
     * @param useCase  用例
     * @param scenario 场景
     * @return 用户业务场景
     */
    public static BizScenario valueOf(String useCase, String scenario) {
        return BizScenario.valueOf(DEFAULT_BIZ_ID, useCase, scenario);
    }

    /**
     * 实例默认用户业务场景
     *
     * @return 默认用户业务场景
     */
    public static BizScenario newDefault() {
        return BizScenario.valueOf(DEFAULT_BIZ_ID, DEFAULT_USE_CASE, DEFAULT_SCENARIO);
    }
}
