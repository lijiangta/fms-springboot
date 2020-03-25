package com.dxs.fms.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 23:54
 */
@Getter
@Setter
@ToString
public class Result1<T> {
    private boolean success;
    private T data;
    private Error error;
    private List<T> list;

    public Result1() {
    }

    public Result1(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result1(boolean success, List<T> list) {
        this.success = success;
        this.list = list;
    }

    public Result1(boolean success, T data, Error error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public Result1(boolean success, List<T> list, Error error) {
        this.success = success;
        this.list = list;
        this.error = error;
    }
}
