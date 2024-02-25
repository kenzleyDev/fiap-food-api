package com.fiap.food.api.category.service;

import com.fiap.food.api.category.mapper.CategoryEntityMapper;
import com.fiap.food.api.category.dto.Category;
import com.fiap.food.core.exception.NotFoundException;
import com.fiap.food.core.model.CategoryEntity;
import com.fiap.food.core.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryEntityMapper categoryEntityMapper;
    @Override
    public void insert(Category category) {
        CategoryEntity categoryEntity = categoryEntityMapper.toCategoryEntity(category);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public void update(Category category) throws NotFoundException {
        var categoryEntity = categoryEntityMapper.toCategoryEntity(category);
        categoryRepository.save(categoryEntity);
    }

    @Override
    public Optional<Category> find(String categoryName) throws NotFoundException {
        var category = categoryRepository.findByName(categoryName);
        return category.map(entity -> categoryEntityMapper.toCategory(entity));
    }

    @Override
    public Optional<Category> find(Long id) throws NotFoundException {
        var categoryEntity = categoryRepository.findById(id);
        return categoryEntity.map(entity -> categoryEntityMapper.toCategory(entity));
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        categoryRepository.deleteById(id);
    }
}
