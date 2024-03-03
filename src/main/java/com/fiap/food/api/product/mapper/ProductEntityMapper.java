package com.fiap.food.api.product.mapper;

import com.fiap.food.core.model.ProductEntity;
import com.fiap.food.api.product.dto.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
