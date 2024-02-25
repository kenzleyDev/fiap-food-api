package com.fiap.food.api.order.mapper;

import com.fiap.food.api.order.dto.OrderRequest;
import com.fiap.food.api.order.dto.OrderResponse;
import com.fiap.food.api.order.dto.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderRequest orderRequest);

    @Mapping(source = "confirmationCode", target = "confirmationCode")
    OrderResponse toOrderResponse(Order order);
}
