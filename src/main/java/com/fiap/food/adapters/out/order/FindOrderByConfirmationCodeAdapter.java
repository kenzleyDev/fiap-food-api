package com.fiap.food.adapters.out.order;

import com.fiap.food.adapters.out.repository.OrderRepository;
import com.fiap.food.adapters.out.repository.mapper.OrderEntityMapper;
import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.ports.out.order.FindOrderByConfirmationCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindOrderByConfirmationCodeAdapter implements FindOrderByConfirmationCodeOutputPort {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderEntityMapper orderEntityMapper;
    @Override
    public Optional<Order> find(String confirmationCode) {
        var orderEntity = orderRepository.findByConfirmationCode(confirmationCode);
        return orderEntity.map(entity -> orderEntityMapper.toOrder(entity));
    }
}
