package com.fiap.food.adapters.in.controller.response;

import com.fiap.food.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private CustomerResponse customer;
    private List<ProductResponse> products;
    private LocalDateTime dateTimeOrder;
    private Double amount;
    private OrderStatus status;
    private String confirmationCode;
}
