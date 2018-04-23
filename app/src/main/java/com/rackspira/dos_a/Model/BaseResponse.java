package com.rackspira.dos_a.Model;

/**
 * Created by Anang S on 23/04/2018.
 */

public class BaseResponse<T> {
    private T data;
    private int status;
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
