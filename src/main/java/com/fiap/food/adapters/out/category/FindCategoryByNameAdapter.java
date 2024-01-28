package com.fiap.food.adapters.out.category;

import com.fiap.food.adapters.out.repository.CategoryRepository;
import com.fiap.food.adapters.out.repository.entity.CategoryEntity;
import com.fiap.food.adapters.out.repository.mapper.CategoryEntityMapper;
import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCategoryByNameAdapter implements FindCategoryByNameOutputPort {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryEntityMapper categoryEntityMapper;
    @Override
    public Optional<Category> find(String categoryName) {
        var category = categoryRepository.findByName(categoryName);
        return category.map(entity -> categoryEntityMapper.toCategory(entity));
    }
}
