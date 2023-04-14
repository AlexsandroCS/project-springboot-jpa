package com.educandoweb.course.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    // Serializable serial number.
    private static final long serialVersionUID = 1L;

    // Atributes.
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestramp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    // Constructors.
    public StandardError(){}
    public StandardError(Instant timestramp, Integer status, String error, String message, String path) {
        this.timestramp = timestramp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters and Setters
    public Instant getTimestramp() {
        return timestramp;
    }
    public void setTimestramp(Instant timestramp) {
        this.timestramp = timestramp;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
}
