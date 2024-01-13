package com.fiap.food.adapters.out.repository.mapper;

import com.fiap.food.adapters.out.repository.entity.OrderEntity;
import com.fiap.food.application.core.domain.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {

    OrderEntity toOrderEntity(Order order);

    Order toOrder(OrderEntity orderEntity);
}
