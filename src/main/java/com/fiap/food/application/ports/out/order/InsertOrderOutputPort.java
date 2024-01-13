package com.fiap.food.application.ports.out.order;

import com.fiap.food.application.core.domain.Order;

public interface InsertOrderOutputPort {

    void insert(Order order);
}
