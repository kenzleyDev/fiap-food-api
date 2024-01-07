package com.fiap.food.adapters.out.product;

import com.fiap.food.adapters.out.repository.ProductRepository;
import com.fiap.food.adapters.out.repository.mapper.ProductEntityMapper;
import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.out.product.InsertProductOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertProductAdapter implements InsertProductOutputPort {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    public void insert(Product product) {
        var productEntity = productEntityMapper.toProductEntity(product);
        productRepository.save(productEntity);
    }
}
