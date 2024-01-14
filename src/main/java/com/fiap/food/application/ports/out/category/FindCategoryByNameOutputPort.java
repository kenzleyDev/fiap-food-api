package com.fiap.food.application.ports.out.category;

import com.fiap.food.application.core.domain.Category;

import java.util.Optional;

public interface FindCategoryByNameOutputPort {
    Optional<Category> find(String categoryName);
}
