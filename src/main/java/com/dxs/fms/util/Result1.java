package com.dxs.fms.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 23:54
 */
public class Result1<T> {
    private boolean success = true;
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

    public Result1(boolean success , List<T> list, Error error) {
        this.success = success;
        this.list = list;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Result1{" +
                "success=" + success +
                ", data=" + data +
                ", error=" + error +
                ", list=" + list +
                '}';
    }
}
