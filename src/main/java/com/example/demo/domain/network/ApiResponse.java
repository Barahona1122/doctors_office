package com.example.demo.domain.network;

import com.example.demo.domain.objects.ApiResponseObject;

public class ApiResponse<T> {
    /**
     * @param <T>
     * @param success
     * @param message
     * @param data
     * @return
     */
    public static <T> ApiResponseObject success(boolean success, String message, T data) {
        return new ApiResponseObject(HttpCodes.successCode, success, message, data);
    }

    /**
     * @param message
     * @param data
     * @return
     */
    public static <T> ApiResponseObject error(String message, T data) {
        return new ApiResponseObject(HttpCodes.errorCode, false, message, data);
    }
}
