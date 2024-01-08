package com.fiap.food.adapters.out.product;

import com.fiap.food.adapters.out.repository.ProductRepository;
import com.fiap.food.adapters.out.repository.entity.ProductEntity;
import com.fiap.food.adapters.out.repository.mapper.ProductEntityMapper;
import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.out.product.FindProductByCategoryNameOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FindProductByCategoryNameAdapter implements FindProductByCategoryNameOutputPort {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductEntityMapper productEntityMapper;
    @Override
    public List<Product> find(String categoryName) {
        List<ProductEntity> products = productRepository.findByCategoryName(categoryName);
        return products.stream().map(productEntityMapper::toProduct).toList();
    }
}
