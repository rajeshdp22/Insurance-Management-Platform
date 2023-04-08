package com.insumanager.Insurance.Management.utils;

import java.time.LocalDate;

public class ApiResponse {
    public ApiResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    private final boolean status;
    private final String message;

    public boolean isSuccess() {
        return status;
    }

    public String getMessage() {

        return message;
    }

    public String getTimestamp(){
        return LocalDate.now().toString();
    }
}
