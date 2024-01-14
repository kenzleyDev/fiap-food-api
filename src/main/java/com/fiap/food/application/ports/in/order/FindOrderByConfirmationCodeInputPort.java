package com.fiap.food.application.ports.in.order;

import com.fiap.food.application.core.domain.Order;

public interface FindOrderByConfirmationCodeInputPort {

    Order find(String confirmationCode);
}
