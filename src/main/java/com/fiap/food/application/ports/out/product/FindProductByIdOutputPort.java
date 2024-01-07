package com.fiap.food.application.ports.out.product;

import com.fiap.food.application.core.domain.Product;

import java.util.Optional;

public interface FindProductByIdOutputPort {

    Optional<Product> find(Long id);
}
