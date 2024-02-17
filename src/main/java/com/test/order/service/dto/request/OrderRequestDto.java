package com.test.order.service.dto.request;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderRequestDto {
    private String customerId;
    private Integer quantity;
    private String productId;
}
