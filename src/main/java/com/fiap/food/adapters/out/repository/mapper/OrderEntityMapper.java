package com.fiap.food.adapters.out.repository.mapper;

import com.fiap.food.adapters.out.repository.entity.OrderEntity;
import com.fiap.food.application.core.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CustomerEntityMapper.class})
public interface OrderEntityMapper {

    @Mapping(source = "customer", target = "customer")
    OrderEntity toOrderEntity(Order order);

    @Mapping(source = "customer", target = "customer")
    Order toOrder(OrderEntity orderEntity);
}