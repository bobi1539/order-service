package com.test.order.service.service.impl;

import com.test.order.service.constant.GlobalMessage;
import com.test.order.service.dto.request.ProductRequestDto;
import com.test.order.service.dto.response.ProductResponseDto;
import com.test.order.service.entity.Product;
import com.test.order.service.helper.BusinessException;
import com.test.order.service.repository.ProductRepository;
import com.test.order.service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto addProduct(ProductRequestDto requestDto) {
        Product product = Product.builder()
                .productId(UUID.randomUUID())
                .productPrice(requestDto.getProductPrice())
                .productDescription(requestDto.getProductDescription())
                .stock(requestDto.getStock())
                .build();
        Product productSaved = productRepository.save(product);
        return buildResponseDto(productSaved);
    }

    @Override
    public ProductResponseDto editProduct(String productId, ProductRequestDto requestDto) {
        Product product = findByProductId(productId);
        product.setProductPrice(requestDto.getProductPrice());
        product.setProductDescription(requestDto.getProductDescription());
        product.setStock(requestDto.getStock());
        Product productUpdated = productRepository.save(product);
        return buildResponseDto(productUpdated);
    }

    @Override
    public ProductResponseDto getProductById(String productId) {
        return buildResponseDto(findByProductId(productId));
    }

    private Product findByProductId(String productId) {
        UUID id;
        try {
            id = UUID.fromString(productId);
        } catch (Exception e) {
            throw new BusinessException(GlobalMessage.UUID_NOT_VALID);
        }
        return productRepository.findById(id).orElseThrow(() -> new BusinessException(GlobalMessage.DATA_NOT_FOUND));
    }

    private ProductResponseDto buildResponseDto(Product product) {
        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .productPrice(product.getProductPrice())
                .productDescription(product.getProductDescription())
                .stock(product.getStock())
                .build();
    }
}
