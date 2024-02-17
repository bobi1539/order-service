package com.test.order.service.controller;

import com.test.order.service.constant.ApiEndpoint;
import com.test.order.service.dto.request.ProductRequestDto;
import com.test.order.service.dto.response.ProductResponseDto;
import com.test.order.service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiEndpoint.PRODUCT)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.addProduct(requestDto);
    }

    @PutMapping("/{productId}")
    public ProductResponseDto editProduct(
            @PathVariable String productId, @RequestBody ProductRequestDto requestDto
    ) {
        return productService.editProduct(productId, requestDto);
    }

    @GetMapping("/{productId}")
    public ProductResponseDto getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }
}
