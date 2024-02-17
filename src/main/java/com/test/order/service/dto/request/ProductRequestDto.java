package com.test.order.service.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductRequestDto {
    private String productPrice;
    private String productDescription;
    private Integer stock;
}
