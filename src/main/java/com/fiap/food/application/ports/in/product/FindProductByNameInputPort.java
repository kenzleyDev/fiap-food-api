package com.fiap.food.application.ports.in.product;

import com.fiap.food.application.core.domain.Product;

public interface FindProductByNameInputPort {

    Product find(String productName);
}
