package com.xy.cola.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈查询参数〉<p>
 * 〈功能详细描述〉
 *
 * @author zixiao
 * @date 17/3/23
 */
public class PagingQuery {

    /**
     * 默认限制数量
     * 建议根据业务表的字段总大小设置合理值
     */
    public static int DEFAULT_LIMIT = 5000;

    /**
     * 偏移量
     */
    private int offset;

    /**
     * 限制数
     */
    private int limit;

    /**
     * 排序条件
     */
    private List<Sort> sorts;

    /**
     * 上一页数据最大Id
     * 注意这种查询必须使用 order by id asc
     */
    private Long lastMaxId;

    public PagingQuery(){
        this(DEFAULT_LIMIT);
    }

    public PagingQuery(int limit){
        this(0, limit);
    }

    public PagingQuery(int offset, int limit){
        this.offset = offset;
        this.limit = limit;
    }

    public void setPagingParam(PagingParam pagingParam) {
        if(pagingParam != null){
            this.setOffset(pagingParam.getOffset());
            this.setLimit(pagingParam.getLimit());
        }
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset < 0 ? 0: offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public Long getLastMaxId() {
        return lastMaxId;
    }

    public void setLastMaxId(Long lastMaxId) {
        this.lastMaxId = lastMaxId;
    }

    /**
     * 新增排序字段
     * @param column 列名
     * @param sortType 排序方式
     */
    public void addOrderBy(String column, Sort.SortType sortType) {
        if(column == null || column.trim().length() == 0){
            throw new IllegalArgumentException("列名不能为空");
        }
        if(sortType == null){
            throw new IllegalArgumentException("排序方式不能为空");
        }
        if(sorts == null){
            sorts = new ArrayList<Sort>(2);
        }
        //防止注入
        column = column.replaceAll(";", "");
        this.sorts.add(new Sort(column, sortType));
    }

    @Override
    public String toString() {
        return "PagingQuery{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", sorts=" + sorts +
                ", lastMaxId=" + lastMaxId +
                '}';
    }
}

