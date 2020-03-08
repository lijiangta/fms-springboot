package com.dxs.fms.util;

/**
 * @author dxs
 * @date 2020/2/27 0027 23:08
 */
public class Result {
    /**
     * 返回前端code
     */
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
