package com.fiap.food.api.product.service;

import com.fiap.food.api.product.dto.Product;
import com.fiap.food.core.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void insert(Product product) throws NotFoundException;
    void delete(Long id);
    void update(Product product);
    List<Product> findByCategoryName(String categoryName);
    Optional<Product> findById(Long id);
    Optional<Product> findByProductName(String productName);
}
