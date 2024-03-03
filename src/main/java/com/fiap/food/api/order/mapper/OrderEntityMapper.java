package com.fiap.food.api.order.mapper;

import com.fiap.food.api.customer.mapper.CustomerEntityMapper;
import com.fiap.food.core.model.OrderEntity;
import com.fiap.food.api.order.dto.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerEntityMapper.class})
public interface OrderEntityMapper {

    @Mapping(source = "customer", target = "customer")
    OrderEntity toOrderEntity(Order order);

    @Mapping(source = "customer", target = "customer")
    Order toOrder(OrderEntity orderEntity);
}