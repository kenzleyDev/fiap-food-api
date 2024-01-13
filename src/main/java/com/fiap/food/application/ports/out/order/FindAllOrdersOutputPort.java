package com.fiap.food.application.ports.out.order;

import com.fiap.food.application.core.domain.Order;

import java.util.List;

public interface FindAllOrdersOutputPort {
    List<Order> findAll();
}
