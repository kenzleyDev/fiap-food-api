package com.fiap.food.api.category.mapper;

import com.fiap.food.core.model.CategoryEntity;
import com.fiap.food.api.category.dto.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);
}
