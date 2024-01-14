package com.fiap.food.application.ports.in.order;

import com.fiap.food.application.core.domain.Order;
import com.fiap.food.errors.exception.NotFoundException;

public interface UpdateConfirmOrderInputPort {

    void update(Order order) throws NotFoundException;
}