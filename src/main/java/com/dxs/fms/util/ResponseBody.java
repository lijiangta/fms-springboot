package com.dxs.fms.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dxs
 * @date 2020/3/8 0008 20:56
 */
@Getter
@Setter
@ToString
public class ResponseBody<T> {
    private String statusCode;
    private String message;
    private T data;
    private Error error;

    public ResponseBody() {

    }

    public ResponseBody(String statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public ResponseBody(String statusCode, Error error, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
    }
}
