package com.fiap.food.application.ports.in.product;

import com.fiap.food.application.core.domain.Product;
import com.fiap.food.errors.exception.NotFoundException;

import java.util.List;

public interface FindProductByCategoryNameInputPort {

    List<Product> find(String categoryName) throws NotFoundException;
}
