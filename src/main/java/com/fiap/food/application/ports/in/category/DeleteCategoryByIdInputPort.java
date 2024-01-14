package com.fiap.food.application.ports.in.category;

import com.fiap.food.errors.exception.NotFoundException;

public interface DeleteCategoryByIdInputPort {

    void delete(Long id) throws NotFoundException;
}
