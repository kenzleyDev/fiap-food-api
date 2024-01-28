package com.fiap.food.adapters.in.controller.mapper;

import com.fiap.food.adapters.in.controller.request.ProductRequest;
import com.fiap.food.adapters.in.controller.response.ProductResponse;
import com.fiap.food.application.core.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductRequest productRequest);

    ProductResponse toProductResponse(Product product);
}
