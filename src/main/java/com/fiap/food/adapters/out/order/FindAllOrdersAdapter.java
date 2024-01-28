package com.fiap.food.adapters.out.order;

import com.fiap.food.adapters.out.repository.OrderRepository;
import com.fiap.food.adapters.out.repository.entity.OrderEntity;
import com.fiap.food.adapters.out.repository.mapper.OrderEntityMapper;
import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.ports.out.order.FindAllOrdersOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllOrdersAdapter implements FindAllOrdersOutputPort {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;
    @Override
    public List<Order> findAll() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream().map(orderEntityMapper::toOrder).toList();
    }
}
