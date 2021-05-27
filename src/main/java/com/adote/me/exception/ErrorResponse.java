package com.adote.me.exception;

import com.google.gson.Gson;

public class ErrorResponse {

    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String createErrorMessage() {
        return new Gson().toJson(this);
    }
}
