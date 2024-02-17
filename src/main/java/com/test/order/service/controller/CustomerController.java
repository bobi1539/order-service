package com.test.order.service.controller;

import com.test.order.service.constant.ApiEndpoint;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiEndpoint.CUSTOMER)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    @GetMapping
    public String test() {
        return "halo";
    }
}
