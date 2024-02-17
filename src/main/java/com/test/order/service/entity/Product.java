package com.test.order.service.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "stock")
    private Integer stock;
}
