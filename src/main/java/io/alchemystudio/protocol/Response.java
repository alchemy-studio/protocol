package io.alchemystudio.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Response<T> {

    @JsonProperty
    private boolean success;

    @JsonProperty
    private T result;

    @JsonProperty
    private String message;

    private Err err;

    private Status status;

    private Id id;

    private Time t;

    public Response() {

    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, T result, String message) {
        this.success = success;
        this.result = result;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}

