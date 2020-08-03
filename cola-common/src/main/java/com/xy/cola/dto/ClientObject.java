package com.xy.cola.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 与客户端通信的对象，可以是视图层或其他HSF消费者
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class ClientObject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展领域对象值
     */
    protected Map<String, Object> extValues = new HashMap<>();

    /**
     * 获取扩展领域对象
     *
     * @param key key
     * @return 领域对象
     */
    public Object getExtField(String key) {
        if (extValues != null) {
            return extValues.get(key);
        }
        return null;
    }

    /**
     * 设置扩展领域对象
     *
     * @param fieldName 领域对象keyName
     * @param value     领域对象
     */
    public void putExtField(String fieldName, Object value) {
        this.extValues.put(fieldName, value);
    }

    public Map<String, Object> getExtValues() {
        return extValues;
    }

    public void setExtValues(Map<String, Object> extValues) {
        this.extValues = extValues;
    }
}
