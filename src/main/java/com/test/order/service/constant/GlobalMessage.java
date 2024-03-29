package com.test.order.service.constant;

import org.springframework.http.HttpStatus;

public enum GlobalMessage {

    SUCCESS(HttpStatus.OK, "Success"),
    UUID_NOT_VALID(HttpStatus.BAD_REQUEST, "Uuid Not Valid"),
    PRODUCT_PRICE_NOT_VALID(HttpStatus.BAD_REQUEST, "Product Price Not Valid"),
    QUANTITY_LESS_THAN_ONE(HttpStatus.BAD_REQUEST, "Quantity Cannot Less Than 1"),
    QUANTITY_GREATER_THAN_STOCK(HttpStatus.BAD_REQUEST, "Quantity Cannot Greater Than Stock"),
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
