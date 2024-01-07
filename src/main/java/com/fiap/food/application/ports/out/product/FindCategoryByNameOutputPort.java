package com.fiap.food.application.ports.out.product;

import com.fiap.food.application.core.domain.Category;

public interface FindCategoryByNameOutputPort {

    Category find(String nameCategory);
}
