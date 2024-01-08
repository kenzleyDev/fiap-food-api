package com.fiap.food.adapters.out.category;

import com.fiap.food.adapters.out.repository.CategoryRepository;
import com.fiap.food.adapters.out.repository.entity.CategoryEntity;
import com.fiap.food.adapters.out.repository.mapper.CategoryEntityMapper;
import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCategoryByNameAdapter implements FindCategoryByNameOutputPort {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryEntityMapper categoryEntityMapper;
    @Override
    public Category find(String categoryName) {
        CategoryEntity category = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryEntityMapper.toCategory(category);
    }
}
