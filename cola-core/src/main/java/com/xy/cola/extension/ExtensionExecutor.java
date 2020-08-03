package com.xy.cola.extension;

import com.xy.cola.boot.AbstractComponentExecutor;
import com.xy.cola.common.ColaConstant;
import com.xy.cola.exception.ColaException;
import com.xy.cola.logger.Logger;
import com.xy.cola.logger.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈扩展执行器〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class ExtensionExecutor extends AbstractComponentExecutor {

    private static final Logger logger = LoggerFactory.getLogger(ExtensionExecutor.class);

    @Resource
    private ExtensionRepository extensionRepository;

    /**
     * 查找扩展点组件
     * <p>
     * 查找说明：
     * 如果用户业务场景身份（bizScenarioUniqueIdentity）是"ali.tmall.supermarket"
     * 业务执行查找路径逻辑如下：
     * 1，首先尝试通过"ali.tmall.supermarket"获得扩展名，如果获得则返回。
     * 2，循环尝试通过"ali.tmall"获取扩展名，如果获取则返回。
     * 3，循环尝试通过"ali"获取扩展名，如果获取则返回。
     * 4，如果找不到，尝试默认扩展名。
     *
     * @param targetClz   扩展点目标类
     * @param bizScenario 业务场景
     * @return 扩展点组件
     */
    @Override
    protected <C> C locateComponent(Class<C> targetClz, BizScenario bizScenario) {
        checkNull(bizScenario);
        String bizScenarioUniqueIdentity = bizScenario.getUniqueIdentity();
        logger.debug("BizScenario in locateExtension is : " + bizScenarioUniqueIdentity);

        // 首次尝试获取
        C extension = firstTry(targetClz, bizScenarioUniqueIdentity);
        if (extension != null) {
            return extension;
        }

        // 循环尝试获取
        extension = loopTry(targetClz, bizScenarioUniqueIdentity);
        if (extension != null) {
            return extension;
        }
        throw new ColaException("Can not find extension with ExtensionPoint: " + targetClz
                + " BizScenario:" + bizScenarioUniqueIdentity);
    }

    /**
     * 首次尝试获取扩展点实现类
     *
     * @param targetClz   扩展点目标类
     * @param bizScenario 业务场景
     * @param <Ext>       参数类型
     * @return 扩展点实现类
     */
    private <Ext> Ext firstTry(Class<Ext> targetClz, String bizScenario) {
        return (Ext) extensionRepository.getExtensionRepository().get(new ExtensionCoordinate(targetClz.getName(), bizScenario));
    }

    /**
     * 循环尝试获取扩展点实现类
     *
     * @param targetClz   扩展点目标类
     * @param bizScenario 业务场景
     * @param <Ext>       参数类型
     * @return 扩展点实现类
     */
    private <Ext> Ext loopTry(Class<Ext> targetClz, String bizScenario) {
        Ext extension;
        if (bizScenario == null) {
            return null;
        }
        int lastDotIndex = bizScenario.lastIndexOf(ColaConstant.DOT_SEPARATOR);
        while (lastDotIndex != -1) {
            bizScenario = bizScenario.substring(0, lastDotIndex);
            extension = (Ext) extensionRepository.getExtensionRepository().get(new ExtensionCoordinate(targetClz.getName(), bizScenario));
            if (extension != null) {
                return extension;
            }
            lastDotIndex = bizScenario.lastIndexOf(ColaConstant.DOT_SEPARATOR);
        }
        return null;
    }

    /**
     * 业务场景参数检查
     *
     * @param bizScenario 业务场景
     */
    private void checkNull(BizScenario bizScenario) {
        if (bizScenario == null) {
            throw new ColaException("BizScenario can not be null for extension");
        }
    }
}
