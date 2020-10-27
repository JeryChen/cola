package com.xy.cola.dto;

import java.io.Serializable;
import java.util.Objects;

public class Sort implements Serializable {

    private static final long serialVersionUID = -3992572843995793776L;

    private String column;

    private SortType type;

    public Sort(String column, SortType type) {
        this.column = column;
        this.type = type;
    }

    public String getColumn() {
        return column;
    }

    public SortType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sort)) {
            return false;
        }

        Sort sort = (Sort) o;

        if (!Objects.equals(column, sort.column)) {
            return false;
        }
        return type == sort.type;

    }

    @Override
    public int hashCode() {
        int result = column != null ? column.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return column + ' ' + type.getMessage();
    }

    public enum SortType {

        /**
         * 排序
         */
        ASC(0, "ASC"),
        DESC(1, "DESC");

        private int value;

        private String message = null;

        private SortType(int value, String message) {
            this.value = value;
            this.message = message;
        }

        public int getValue() {
            return value;
        }

        public String getMessage() {
            return message;
        }

        /**
         * 通过枚举<code>value</code>获得枚举
         *
         * @param value
         * @return
         */
        public static SortType getByValue(int value) {
            for (SortType sortTypeEnum : values()) {
                if (sortTypeEnum.getValue() == value) {
                    return sortTypeEnum;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return value + "|" + message;
        }

    }

}


