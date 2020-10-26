package com.xy.cola.common;

/**
 * 〈分表分页查询〉<p>
 * 〈功能详细描述〉
 *
 * @author zixiao
 * @date 18/6/4
 */
public class ShardingQuery extends PagingQuery {

    /**
     * 表索引号，从0开始
     */
    private int tableIndex;

    /**
     * 表后缀
     */
    private String tableSuffix;

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    @Override
    public String toString() {
        return "ShardingQuery{" +
                "tableIndex=" + tableIndex +
                ", tableSuffix='" + tableSuffix + '\'' +
                '}';
    }
}
