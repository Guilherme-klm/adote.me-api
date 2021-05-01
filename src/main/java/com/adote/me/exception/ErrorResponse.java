package com.adote.me.exception;

import static java.lang.String.*;

public class ErrorResponse {

    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String createErrorMessage() {
        return format("{'message': '%s'}", errorMessage);
    }
}
