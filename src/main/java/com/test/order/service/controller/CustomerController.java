package com.test.order.service.controller;

import com.test.order.service.constant.ApiEndpoint;
import com.test.order.service.dto.request.CustomerRequestDto;
import com.test.order.service.dto.response.CustomerResponseDto;
import com.test.order.service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndpoint.CUSTOMER)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponseDto addCustomer(@RequestBody CustomerRequestDto requestDto) {
        return customerService.addCustomer(requestDto);
    }

    @PutMapping("/{customerId}")
    public CustomerResponseDto editCustomer(
            @PathVariable String customerId, @RequestBody CustomerRequestDto requestDto
    ) {
        return customerService.editCustomer(customerId, requestDto);
    }

    @GetMapping("/{customerId}")
    public CustomerResponseDto getCustomerById(@PathVariable String customerId) {
        return customerService.getCustomerById(customerId);
    }
}
