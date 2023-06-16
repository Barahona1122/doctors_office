package com.example.demo.domain.objects;

import java.util.List;

public class ApiResponseObject<T> {
    private boolean success;
    private String message;
    private T data;
    private int statusCode;

    /**
     * @param statusCode
     * @param success
     * @param message
     * @param data
     */
    public ApiResponseObject(int statusCode, boolean success, String message, T data) {
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     * @return
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return
     */
    public T getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
