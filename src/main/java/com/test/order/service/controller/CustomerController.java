package com.test.order.service.controller;

import com.test.order.service.constant.ApiEndpoint;
import com.test.order.service.dto.request.AddCustomerRequestDto;
import com.test.order.service.dto.response.CustomerResponseDto;
import com.test.order.service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiEndpoint.CUSTOMER)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponseDto addCustomer(@RequestBody AddCustomerRequestDto requestDto) {
        return customerService.addCustomer(requestDto);
    }
}
