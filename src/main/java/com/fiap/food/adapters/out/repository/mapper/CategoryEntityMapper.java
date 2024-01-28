package com.fiap.food.adapters.out.repository.mapper;

import com.fiap.food.adapters.out.repository.entity.CategoryEntity;
import com.fiap.food.application.core.domain.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);
}
