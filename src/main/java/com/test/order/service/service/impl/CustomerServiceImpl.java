package com.test.order.service.service.impl;

import com.test.order.service.dto.request.AddCustomerRequestDto;
import com.test.order.service.dto.request.UpdateCustomerRequestDto;
import com.test.order.service.dto.response.CustomerResponseDto;
import com.test.order.service.entity.Customer;
import com.test.order.service.repository.CustomerRepository;
import com.test.order.service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto addCustomer(AddCustomerRequestDto requestDto) {
        Customer customer = Customer.builder()
                .customerId(UUID.randomUUID())
                .customerName(requestDto.getCustomerName())
                .address(requestDto.getAddress())
                .phone(requestDto.getPhone())
                .build();
        Customer customerSaved = customerRepository.save(customer);
        return CustomerResponseDto.builder()
                .customerId(customerSaved.getCustomerId())
                .customerName(customerSaved.getCustomerName())
                .address(customerSaved.getAddress())
                .phone(customerSaved.getPhone())
                .build();
    }

    @Override
    public CustomerResponseDto updateCustomer(String customerId, UpdateCustomerRequestDto requestDto) {
        return null;
    }

    @Override
    public CustomerResponseDto getCustomerById(String customerId) {
        return null;
    }
}
