package com.fiap.food.application.ports.in.category;

import com.fiap.food.application.core.domain.Category;

public interface FindCategoryByNameInputPort {

    Category find(String categoryName);
}
