package com.test.order.service.constant;

import org.springframework.http.HttpStatus;

public enum GlobalMessage {

    SUCCESS(HttpStatus.OK, "Success"),
    UUID_NOT_VALID(HttpStatus.BAD_REQUEST, "Uuid Not Valid"),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "Data Not Found"),
    CANNOT_INSTANCE_HELPER_CLASS(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    public final HttpStatus httpStatus;
    public final String message;

    GlobalMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
