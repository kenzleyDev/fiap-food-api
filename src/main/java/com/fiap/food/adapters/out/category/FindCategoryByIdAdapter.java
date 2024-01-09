package com.fiap.food.adapters.out.category;

import com.fiap.food.adapters.out.repository.CategoryRepository;
import com.fiap.food.adapters.out.repository.mapper.CategoryEntityMapper;
import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.out.category.FindCategoryByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCategoryByIdAdapter implements FindCategoryByIdOutputPort {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryEntityMapper categoryEntityMapper;
    @Override
    public Optional<Category> find(Long id) {
        var categoryEntity = categoryRepository.findById(id);
        return categoryEntity.map(entity -> categoryEntityMapper.toCategory(entity));
    }
}
