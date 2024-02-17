package com.test.order.service.dto.response;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponseDto {
    private UUID customerId;
    private String customerName;
    private String address;
    private Integer phone;
}
