package com.fiap.food.api.category.service;

import com.fiap.food.api.category.dto.Category;
import com.fiap.food.core.exception.NotFoundException;

import java.util.Optional;

public interface CategoryService {
    void insert(Category category);
    void update(Category category) throws NotFoundException;
    Optional<Category> find(String categoryName) throws NotFoundException;
    Optional<Category> find(Long id) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
}
