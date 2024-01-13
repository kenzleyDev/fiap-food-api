package com.fiap.food.adapters.out.order;

import com.fiap.food.adapters.out.repository.OrderRepository;
import com.fiap.food.adapters.out.repository.mapper.OrderEntityMapper;
import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.ports.out.order.InsertOrderOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertOrderAdapter implements InsertOrderOutputPort {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;
    @Override
    public void insert(Order order) {
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        orderRepository.save(orderEntity);
    }
}