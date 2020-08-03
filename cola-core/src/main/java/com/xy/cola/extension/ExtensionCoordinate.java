package com.xy.cola.extension;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈扩展坐标〉
 * 用于定位唯一扩展点
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ExtensionCoordinate {

    /**
     * 扩展点名
     */
    private String extensionPointName;

    /**
     * 业务场景唯一身份标识
     */
    private String bizScenarioUniqueIdentity;

    /**
     * 扩展点类
     */
    private Class extensionPointClass;

    /**
     * 业务场景
     */
    private BizScenario bizScenario;

    /**
     * 构造器（构造扩展类坐标）
     *
     * @param extPtClass  扩展点类
     * @param bizScenario 业务场景
     */
    public ExtensionCoordinate(Class extPtClass, BizScenario bizScenario) {
        this.extensionPointClass = extPtClass;
        this.extensionPointName = extPtClass.getName();
        this.bizScenario = bizScenario;
        this.bizScenarioUniqueIdentity = bizScenario.getUniqueIdentity();
    }

    /**
     * 构造器（构造扩展类坐标）
     *
     * @param extensionPointName        扩展点名
     * @param bizScenarioUniqueIdentity 业务场景唯一身份标识
     */
    public ExtensionCoordinate(String extensionPointName, String bizScenarioUniqueIdentity) {
        this.extensionPointName = extensionPointName;
        this.bizScenarioUniqueIdentity = bizScenarioUniqueIdentity;
    }

    /**
     * 构造扩展类坐标
     *
     * @param extPtClass  扩展点类
     * @param bizScenario 业务场景
     * @return 扩展类坐标
     */
    public static ExtensionCoordinate valueOf(Class extPtClass, BizScenario bizScenario) {
        return new ExtensionCoordinate(extPtClass, bizScenario);
    }

    public Class getExtensionPointClass() {
        return extensionPointClass;
    }

    public BizScenario getBizScenario() {
        return bizScenario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bizScenarioUniqueIdentity == null) ? 0 : bizScenarioUniqueIdentity.hashCode());
        result = prime * result + ((extensionPointName == null) ? 0 : extensionPointName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ExtensionCoordinate other = (ExtensionCoordinate) obj;
        if (bizScenarioUniqueIdentity == null) {
            if (other.bizScenarioUniqueIdentity != null) {
                return false;
            }
        } else if (!bizScenarioUniqueIdentity.equals(other.bizScenarioUniqueIdentity)) {
            return false;
        }
        if (extensionPointName == null) {
            if (other.extensionPointName != null) {
                return false;
            }
        } else if (!extensionPointName.equals(other.extensionPointName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExtensionCoordinate [extensionPointName=" + extensionPointName + ", bizScenarioUniqueIdentity=" + bizScenarioUniqueIdentity + "]";
    }
}
