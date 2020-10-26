package com.xy.cola.common;

import java.io.Serializable;

/**
 * 〈一句话介绍功能〉<br>
 * 基础响应结果
 *
 * @author jierui on 2019-04-11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseResp implements Serializable {

    public static final Integer SUCCESS = 1;

    public static final Integer FAIL = -1;

    /**
     * 处理结果
     */
    private Integer status;

    /**
     * 备注
     */
    private String message;

    /**
     * 构建成功响应结果
     *
     * @param message 备注信息
     * @return 响应结果
     */
    public static BaseResp buildSuccess(String message) {
        BaseResp resp = new BaseResp();
        resp.setStatus(SUCCESS);
        resp.setMessage(message);
        return resp;
    }

    /**
     * 构建失败响应结果
     *
     * @param message 备注信息
     * @return 响应结果
     */
    public static BaseResp buildFail(String message) {
        BaseResp resp = new BaseResp();
        resp.setStatus(FAIL);
        resp.setMessage(message);
        return resp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
