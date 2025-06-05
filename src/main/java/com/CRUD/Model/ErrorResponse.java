package com.CRUD.Model;

import java.time.LocalDateTime;

public class ErrorResponse {
    LocalDateTime localDateTime;
    String errorMessage;
    String errorCode;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorResponse(String errorMessage, String errorCode) {
        this.localDateTime=LocalDateTime.now();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
