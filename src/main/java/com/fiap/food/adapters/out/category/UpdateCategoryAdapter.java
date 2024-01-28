package com.fiap.food.adapters.out.category;

import com.fiap.food.adapters.out.repository.CategoryRepository;
import com.fiap.food.adapters.out.repository.mapper.CategoryEntityMapper;
import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.out.category.UpdateCategoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryAdapter implements UpdateCategoryOutputPort {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryEntityMapper categoryEntityMapper;
    @Override
    public void update(Category category) {
        var categoryEntity = categoryEntityMapper.toCategoryEntity(category);
        categoryRepository.save(categoryEntity);
    }
}
