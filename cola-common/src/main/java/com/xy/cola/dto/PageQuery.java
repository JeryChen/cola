package com.xy.cola.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 分页查询
 *
 * @author xingyi on 2020/8/2.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class PageQuery extends Query {

    /**
     * 当前页
     */
    private int pageNum = 1;

    /**
     * 每页大小
     */
    private int pageSize = 10;

    /**
     * 是否需要总数
     */
    private boolean needTotalCount = true;

    /**
     *
     */
    private List<OrderDesc> orderDescList;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

    public List<OrderDesc> getOrderDescList() {
        return orderDescList;
    }

    public void addOrderDesc(OrderDesc orderDesc) {
        if (null == orderDescList) {
            orderDescList = new ArrayList<>();
        }
        orderDescList.add(orderDesc);
    }

    /**
     * 获取分页偏移量
     *
     * @return 分页偏移量
     */
    public int getOffset() {
        return pageNum > 0 ? (pageNum - 1) * pageSize : 0;
    }
}
