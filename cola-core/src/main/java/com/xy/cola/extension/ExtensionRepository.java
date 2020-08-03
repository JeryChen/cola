package com.xy.cola.extension;

import com.xy.cola.exception.ColaException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈扩展点注册库〉
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class ExtensionRepository {

    /**
     * 扩展点注册库容器
     */
    private Map<ExtensionCoordinate, ExtensionPointI> extensionRepository = new HashMap<>();

    /**
     * 获取扩展点注册库容器
     *
     * @return 扩展点注册库容器
     */
    public Map<ExtensionCoordinate, ExtensionPointI> getExtensionRepository() {
        return extensionRepository;
    }

    /**
     * 注册扩展点
     *
     * @param extensionCoordinate 定位唯一扩展点信息
     * @param extensionPointI     扩展点
     */
    public void register(ExtensionCoordinate extensionCoordinate, ExtensionPointI extensionPointI) {
        ExtensionPointI pointI = extensionRepository.put(extensionCoordinate, extensionPointI);
        if (null != pointI) {
            throw new ColaException("Duplicate registration is not allowed for :" + extensionCoordinate);
        }
    }
}
