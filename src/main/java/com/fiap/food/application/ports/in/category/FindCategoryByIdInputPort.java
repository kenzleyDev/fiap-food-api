package com.fiap.food.application.ports.in.category;

import com.fiap.food.application.core.domain.Category;
import com.fiap.food.errors.exception.NotFoundException;

public interface FindCategoryByIdInputPort {

    Category find(Long id) throws NotFoundException;
}
