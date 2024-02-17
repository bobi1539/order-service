package com.test.order.service.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateCustomerRequestDto {
    private String customerName;
    private String address;
    private Integer phone;
}
