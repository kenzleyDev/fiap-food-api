package com.fiap.food.api.payment.dto;

import com.fiap.food.api.order.dto.Order;
import com.fiap.food.enums.StatusPaymentEnum;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Payment {
    private Long id;
    private BigDecimal amount;
    private StatusPaymentEnum statusPayment;
    private Order order;
}
