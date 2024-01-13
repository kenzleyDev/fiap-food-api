package com.fiap.food.adapters.in.controller.mapper;

import com.fiap.food.adapters.in.controller.request.OrderRequest;
import com.fiap.food.adapters.in.controller.response.OrderResponse;
import com.fiap.food.application.core.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderRequest orderRequest);

    @Mapping(source = "confirmationCode", target = "confirmationCode")
    OrderResponse toOrderResponse(Order order);
}
