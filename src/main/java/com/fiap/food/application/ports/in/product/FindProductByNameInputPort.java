package com.fiap.food.application.ports.in.product;

import com.fiap.food.application.core.domain.Product;
import com.fiap.food.errors.exception.NotFoundException;

public interface FindProductByNameInputPort {

    Product find(String productName) throws NotFoundException;
}
