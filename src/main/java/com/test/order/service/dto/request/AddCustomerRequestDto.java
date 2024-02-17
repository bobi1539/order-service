package com.test.order.service.dto.request;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddCustomerRequestDto {
    private String customerName;
    private String address;
    private Integer phone;
}
