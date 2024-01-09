package com.fiap.food.application.ports.out.category;

import com.fiap.food.application.core.domain.Category;

public interface InsertCategoryOutputPort {

    void insert(Category category);

}
