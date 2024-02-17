package com.test.order.service.service;

import com.test.order.service.dto.request.ProductRequestDto;
import com.test.order.service.dto.response.ProductResponseDto;

public interface ProductService {

    ProductResponseDto addProduct(ProductRequestDto requestDto);

    ProductResponseDto editProduct(String productId, ProductRequestDto requestDto);

    ProductResponseDto getProductById(String productId);
}
