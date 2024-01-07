package com.fiap.food.application.ports.in.product;

import com.fiap.food.application.core.domain.Product;

public interface InsertProductInputPort {

    void insert(Product product, String categoryName);
}
