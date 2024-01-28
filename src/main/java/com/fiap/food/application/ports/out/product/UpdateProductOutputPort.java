package com.fiap.food.application.ports.out.product;

import com.fiap.food.application.core.domain.Product;

public interface UpdateProductOutputPort {

    void update(Product product);
}
