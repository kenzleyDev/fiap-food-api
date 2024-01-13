package com.fiap.food.application.ports.in.category;

import com.fiap.food.application.core.domain.Category;

public interface UpdateCategoryInputPort {

    void update(Category category);
}
