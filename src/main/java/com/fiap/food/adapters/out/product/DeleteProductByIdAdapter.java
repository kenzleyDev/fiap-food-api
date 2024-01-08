package com.fiap.food.adapters.out.product;

import com.fiap.food.adapters.out.repository.ProductRepository;
import com.fiap.food.application.ports.out.product.DeleteProductByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductByIdAdapter implements DeleteProductByIdOutputPort {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
