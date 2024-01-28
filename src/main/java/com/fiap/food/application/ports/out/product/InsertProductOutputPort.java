package com.fiap.food.application.ports.out.product;

import com.fiap.food.application.core.domain.Product;

public interface InsertProductOutputPort {

    void insert(Product product);
}
