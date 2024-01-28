package com.fiap.food.application.ports.in.order;

import com.fiap.food.application.core.domain.Order;

import java.util.List;

public interface FindAllOrdersInputPort {

    List<Order> findAll();
}
