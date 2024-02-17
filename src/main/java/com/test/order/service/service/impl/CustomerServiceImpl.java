package com.test.order.service.service.impl;

import com.test.order.service.constant.GlobalMessage;
import com.test.order.service.dto.request.CustomerRequestDto;
import com.test.order.service.dto.response.CustomerResponseDto;
import com.test.order.service.entity.Customer;
import com.test.order.service.helper.BusinessException;
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
    public CustomerResponseDto addCustomer(CustomerRequestDto requestDto) {
        Customer customer = Customer.builder()
                .customerId(UUID.randomUUID())
                .customerName(requestDto.getCustomerName())
                .address(requestDto.getAddress())
                .phone(requestDto.getPhone())
                .build();
        Customer customerSaved = customerRepository.save(customer);
        return buildResponseDto(customerSaved);
    }

    @Override
    public CustomerResponseDto editCustomer(String customerId, CustomerRequestDto requestDto) {
        Customer customer = findByCustomerId(customerId);
        customer.setCustomerName(requestDto.getCustomerName());
        customer.setAddress(requestDto.getAddress());
        customer.setPhone(requestDto.getPhone());
        Customer customerUpdated = customerRepository.save(customer);
        return buildResponseDto(customerUpdated);
    }

    @Override
    public CustomerResponseDto getCustomerById(String customerId) {
        return buildResponseDto(findByCustomerId(customerId));
    }

    private Customer findByCustomerId(String customerId) {
        UUID id;
        try {
            id = UUID.fromString(customerId);
        } catch (Exception e) {
            throw new BusinessException(GlobalMessage.UUID_NOT_VALID);
        }
        return customerRepository.findById(id).orElseThrow(() -> new BusinessException(GlobalMessage.DATA_NOT_FOUND));
    }

    private CustomerResponseDto buildResponseDto(Customer customer) {
        return CustomerResponseDto.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .build();
    }
}
