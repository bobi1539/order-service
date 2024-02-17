package com.test.order.service.controller;

import com.test.order.service.constant.Common;
import com.test.order.service.constant.GlobalMessage;
import com.test.order.service.dto.response.BaseResponse;
import com.test.order.service.helper.BusinessException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ErrorHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> exception(Exception e) {
        log.error(Common.ERROR, e);

        BaseResponse<Object> baseResponse = BaseResponse.builder()
                .code(GlobalMessage.INTERNAL_SERVER_ERROR.httpStatus.value())
                .message(GlobalMessage.INTERNAL_SERVER_ERROR.message)
                .build();
        return new ResponseEntity<>(baseResponse, GlobalMessage.INTERNAL_SERVER_ERROR.httpStatus);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse<Object>> exception(BusinessException e) {
        log.error(Common.ERROR, e);

        BaseResponse<Object> baseResponse = BaseResponse.builder()
                .code(e.getHttpStatus().value())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(baseResponse, e.getHttpStatus());
    }
}
