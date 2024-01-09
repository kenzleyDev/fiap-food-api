package com.fiap.food.adapters.in.controller.mapper;

import com.fiap.food.adapters.in.controller.request.CategoryRequest;
import com.fiap.food.adapters.in.controller.response.CategoryResponse;
import com.fiap.food.application.core.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    Category toCategory(CategoryRequest categoryRequest);

    CategoryResponse toCategoryResponse(Category category);
}
