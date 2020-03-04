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

    private Context context;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Err getErr() {
        return err;
    }

    public void setErr(Err err) {
        this.err = err;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Time getT() {
        return t;
    }

    public void setT(Time t) {
        this.t = t;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

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

