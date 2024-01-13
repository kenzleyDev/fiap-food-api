package com.fiap.food.application.core.usecase.order;

import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.ports.in.order.FindAllOrdersInputPort;
import com.fiap.food.application.ports.out.order.FindAllOrdersOutputPort;

import java.util.List;

public class FindAllOrdersUseCase implements FindAllOrdersInputPort {

    private final FindAllOrdersOutputPort findAllOrdersOutputPort;

    public FindAllOrdersUseCase(FindAllOrdersOutputPort findAllOrdersOutputPort) {
        this.findAllOrdersOutputPort = findAllOrdersOutputPort;
    }

    @Override
    public List<Order> findAll() {
        return findAllOrdersOutputPort.findAll();
    }
}
