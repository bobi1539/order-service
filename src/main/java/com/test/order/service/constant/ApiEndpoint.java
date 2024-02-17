package com.test.order.service.constant;

import com.test.order.service.helper.BusinessException;

public final class ApiEndpoint {

    private ApiEndpoint() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String BASE_ENDPOINT = "/api/order";
    public static final String CUSTOMER = BASE_ENDPOINT + "/customers";
}
