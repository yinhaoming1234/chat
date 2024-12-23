package com.aigoverse.common.pojo;

import lombok.Data;

@Data
public class Result<T> {
    private T data;
    private String message;
    private boolean success;

    public static<E>  Result<E> success(E data) {
        Result result = new Result();
        result.setData(data);
        result.setSuccess(true);
        return result;
    }
    public static Result fail(String message) {
        Result result = new Result();
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }
    public static Result fail() {
        Result result = new Result();
        result.setSuccess(false);
        return result;
    }
    public static Result success() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }



}