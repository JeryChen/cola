package com.xy.cola.common;

import java.io.Serializable;
import java.util.List;

/**
 * 〈分页查询结果〉<p>
 * 〈功能详细描述〉
 *
 * @author zixiao
 * @date 18/11/29
 */
public final class PagingResult<Q extends PagingQuery, T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Q query;

    private List<T> data;

    /**
     * 是否最后一页
     */
    private boolean lastPage;

    public PagingResult(Q query, List<T> data, boolean lastPage) {
        this.query = query;
        this.data = data;
        this.lastPage = lastPage;
    }

    public PagingResult(Q query, List<T> data) {
        this.query = query;
        this.data = data;
    }

    public Q getQuery() {
        return query;
    }

    public void setQuery(Q query) {
        this.query = query;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PagingResult{" +
                "query=" + query +
                ", data=" + data +
                ", lastPage=" + lastPage +
                '}';
    }
}
