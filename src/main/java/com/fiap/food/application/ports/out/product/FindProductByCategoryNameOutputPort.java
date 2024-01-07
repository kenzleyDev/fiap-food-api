package com.fiap.food.application.ports.out.product;

import com.fiap.food.application.core.domain.Product;

import java.util.List;

public interface FindProductByCategoryNameOutputPort {

    List<Product> find(String categoryName);
}
