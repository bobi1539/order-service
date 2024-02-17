package com.test.order.service.service;

import com.test.order.service.dto.request.OrderRequestDto;
import com.test.order.service.dto.response.OrderResponseDto;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto requestDto);
}
