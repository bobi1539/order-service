package com.test.order.service.service;

import com.test.order.service.dto.request.AddCustomerRequestDto;
import com.test.order.service.dto.request.UpdateCustomerRequestDto;
import com.test.order.service.dto.response.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto addCustomer(AddCustomerRequestDto requestDto);

    CustomerResponseDto updateCustomer(String customerId, UpdateCustomerRequestDto requestDto);

    CustomerResponseDto getCustomerById(String customerId);
}
