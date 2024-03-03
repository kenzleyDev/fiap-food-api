package com.fiap.food.api.category.mapper;

import com.fiap.food.api.category.dto.CategoryRequest;
import com.fiap.food.api.category.dto.CategoryResponse;
import com.fiap.food.api.category.dto.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    Category toCategory(CategoryRequest categoryRequest);

    CategoryResponse toCategoryResponse(Category category);
}
