package com.test.order.service.service.impl;

import com.test.order.service.constant.GlobalMessage;
import com.test.order.service.dto.request.OrderRequestDto;
import com.test.order.service.dto.response.CustomerResponseDto;
import com.test.order.service.dto.response.OrderResponseDto;
import com.test.order.service.dto.response.ProductResponseDto;
import com.test.order.service.entity.Customer;
import com.test.order.service.entity.Order;
import com.test.order.service.entity.Product;
import com.test.order.service.helper.BusinessException;
import com.test.order.service.repository.CustomerRepository;
import com.test.order.service.repository.OrderRepository;
import com.test.order.service.repository.ProductRepository;
import com.test.order.service.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Customer customer = findByCustomerId(requestDto.getCustomerId());
        Product product = findProductById(requestDto.getProductId());

        checkQuantityAndUpdateStockProduct(requestDto.getQuantity(), product);
        BigDecimal amount = calculateAmount(product.getProductPrice(), requestDto.getQuantity());

        Order order = Order.builder()
                .orderId(UUID.randomUUID())
                .customer(customer)
                .customerName(customer.getCustomerName())
                .amount(amount)
                .quantity(requestDto.getQuantity())
                .product(product)
                .orderDate(LocalDateTime.now())
                .build();

        Order orderSaved = orderRepository.save(order);
        return buildResponseDto(orderSaved);
    }

    private Customer findByCustomerId(String customerId) {
        UUID id;
        try {
            id = UUID.fromString(customerId);
        } catch (Exception e) {
            throw new BusinessException(GlobalMessage.UUID_NOT_VALID);
        }
        return customerRepository.findById(id).orElseThrow(() -> new BusinessException(GlobalMessage.DATA_NOT_FOUND));
    }

    private Product findProductById(String productId) {
        UUID id;
        try {
            id = UUID.fromString(productId);
        } catch (Exception e) {
            throw new BusinessException(GlobalMessage.UUID_NOT_VALID);
        }
        return productRepository.findById(id).orElseThrow(() -> new BusinessException(GlobalMessage.DATA_NOT_FOUND));
    }

    private BigDecimal calculateAmount(String productPriceStr, Integer quantity) {
        double productPrice;
        try {
            productPrice = Double.parseDouble(productPriceStr);
        } catch (Exception e) {
            throw new BusinessException(GlobalMessage.PRODUCT_PRICE_NOT_VALID);
        }

        double amount = productPrice * quantity;
        return BigDecimal.valueOf(amount);
    }

    private OrderResponseDto buildResponseDto(Order order) {
        Customer customer = order.getCustomer();
        CustomerResponseDto customerResponseDto = CustomerResponseDto.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .build();

        Product product = order.getProduct();
        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .productId(product.getProductId())
                .productPrice(product.getProductPrice())
                .productDescription(product.getProductDescription())
                .stock(product.getStock())
                .build();

        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .customer(customerResponseDto)
                .customerName(customerResponseDto.getCustomerName())
                .amount(order.getAmount())
                .quantity(order.getQuantity())
                .product(productResponseDto)
                .orderDate(order.getOrderDate())
                .build();
    }

    private void checkQuantityAndUpdateStockProduct(int quantity, Product product) {
        int stock = product.getStock();

        if (quantity < 1) {
            throw new BusinessException(GlobalMessage.QUANTITY_LESS_THAN_ONE);
        }
        if (quantity > stock) {
            throw new BusinessException(GlobalMessage.QUANTITY_GREATER_THAN_STOCK);
        }

        stock -= quantity;
        product.setStock(stock);
        productRepository.save(product);
    }
}
