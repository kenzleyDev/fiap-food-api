package com.fiap.food.adapters.out.product;

import com.fiap.food.adapters.out.repository.ProductRepository;
import com.fiap.food.adapters.out.repository.mapper.ProductEntityMapper;
import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.out.product.FindProductByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindProductByIdAdapter implements FindProductByIdOutputPort {
    @Autowired
     private ProductRepository productRepository;
    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    public Optional<Product> find(Long id) {
        var productEntity = productRepository.findById(id);
        return productEntity.map(entity -> productEntityMapper.toProduct(entity));
    }
}
