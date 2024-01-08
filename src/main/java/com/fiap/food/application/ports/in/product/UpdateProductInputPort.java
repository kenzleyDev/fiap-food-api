package com.fiap.food.application.ports.in.product;

import com.fiap.food.application.core.domain.Product;

public interface UpdateProductInputPort {
    void update(Product product, String categoryName);
}
