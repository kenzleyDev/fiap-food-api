package com.fiap.food.api.product.mapper;

import com.fiap.food.api.product.dto.ProductRequest;
import com.fiap.food.api.product.dto.ProductResponse;
import com.fiap.food.api.product.dto.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductRequest productRequest);

    ProductResponse toProductResponse(Product product);
}
