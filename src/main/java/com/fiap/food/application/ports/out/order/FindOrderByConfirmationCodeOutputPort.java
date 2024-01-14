package com.fiap.food.application.ports.out.order;

import com.fiap.food.application.core.domain.Order;

import java.util.Optional;

public interface FindOrderByConfirmationCodeOutputPort {

    Optional<Order> find(String confirmationCode);
}
