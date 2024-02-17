package com.test.order.service.service;

import com.test.order.service.dto.request.CustomerRequestDto;
import com.test.order.service.dto.response.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto addCustomer(CustomerRequestDto requestDto);

    CustomerResponseDto editCustomer(String customerId, CustomerRequestDto requestDto);

    CustomerResponseDto getCustomerById(String customerId);
}
