package com.test.order.service.dto.response;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponseDto {
    private UUID productId;
    private String productPrice;
    private String productDescription;
    private Integer stock;
}
