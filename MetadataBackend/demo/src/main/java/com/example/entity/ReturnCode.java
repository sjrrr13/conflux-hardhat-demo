package com.example.entity;

public enum ReturnCode {
    // success
    RC200(200, "Success"),
    // bad request
    RC400(400, "Bad Request"),
    // no auth
    RC403(403, "No Authorization"),
    // not found
    RC404(404, "Not Found"),
    // internal error
    RC500(500, "Internal Error");

    // 状态码
    private final int code;
    // 描述
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
