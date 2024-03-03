package com.fiap.food.api.order.dto;

import com.fiap.food.api.customer.dto.Customer;
import com.fiap.food.api.payment.dto.Payment;
import com.fiap.food.api.product.dto.Product;
import com.fiap.food.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {
    private Long id;
    private Customer customer;
    private List<Product> products;
    private LocalDateTime dateTimeOrder;
    private OrderStatus status;
    private String confirmationCode;

}
