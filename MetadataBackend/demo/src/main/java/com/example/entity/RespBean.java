package com.example.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean<T> {
    private int code;
    private String message;
    private T data;

    // success
    public static <T> RespBean<T> success() {
        return new RespBean<T>(
                ReturnCode.RC200.getCode(),
                ReturnCode.RC200.getMessage(),
                null);
    }

    // success with response
    public static <T> RespBean<T> success(T data) {
        return new RespBean<T>(
                ReturnCode.RC200.getCode(),
                ReturnCode.RC200.getMessage(),
                data);
    }

    // bad request
    public static <T> RespBean<T> badRequest(T data) {
        return new RespBean<T>(
                ReturnCode.RC400.getCode(),
                ReturnCode.RC400.getMessage(),
                data);
    }

    // no auth
    public static <T> RespBean<T> noAuth() {
        return new RespBean<T>(
                ReturnCode.RC403.getCode(),
                ReturnCode.RC403.getMessage(),
                null);
    }

    // not found
    public static <T> RespBean<T> notFound() {
        return new RespBean<T>(
                ReturnCode.RC404.getCode(),
                ReturnCode.RC404.getMessage(),
                null);
    }

    // internal error
    public static <T> RespBean<T> internal() {
        return new RespBean<T>(
                ReturnCode.RC500.getCode(),
                ReturnCode.RC500.getMessage(),
                null);
    }
}
