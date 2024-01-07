package com.fiap.food.adapters.out.repository.mapper;

import com.fiap.food.adapters.out.repository.entity.ProductEntity;
import com.fiap.food.application.core.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
