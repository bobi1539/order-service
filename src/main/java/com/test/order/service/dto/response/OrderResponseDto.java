package com.test.order.service.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponseDto {
    private UUID orderId;
    private CustomerResponseDto customer;
    private String customerName;
    private BigDecimal amount;
    private Integer quantity;
    private ProductResponseDto product;
    private LocalDateTime orderDate;
}
