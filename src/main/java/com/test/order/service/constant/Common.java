package com.test.order.service.constant;

import com.test.order.service.helper.BusinessException;

public class Common {
    private Common() {
        throw new BusinessException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String ERROR = "ERROR";
}
