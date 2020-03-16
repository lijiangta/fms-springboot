package com.dxs.fms.util;

import java.util.List;

/**
 * @author dxs
 * @date 2020/3/15 0015 10:52
 */
public class PageUtils<T> {
    private Integer current;
    private Integer limit;
    private List<T> date;
    private Integer total;

    public static Integer calculateStart(Integer current, Integer limit){
        if(current == 1){
            return 0;
        }
        return (current - 1) * limit;
    }

    public static Integer calculateEnd(Integer current, Integer limit){
        if(current == 1){
            return limit - 1;
        }
        return current * limit - 1;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<T> getDate() {
        return date;
    }

    public void setDate(List<T> date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "current=" + current +
                ", limit=" + limit +
                ", date=" + date +
                '}';
    }
}
