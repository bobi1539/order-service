package com.test.order.service.helper;

import com.test.order.service.constant.GlobalMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;

    public BusinessException(GlobalMessage globalMessage) {
        super(globalMessage.message);
        this.httpStatus = globalMessage.httpStatus;
        this.message = globalMessage.message;
    }
}
