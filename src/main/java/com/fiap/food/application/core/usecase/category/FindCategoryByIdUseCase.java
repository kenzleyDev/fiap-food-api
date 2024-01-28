package com.fiap.food.application.core.usecase.category;

import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.out.category.FindCategoryByIdOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class FindCategoryByIdUseCase implements FindCategoryByIdInputPort {

    private final FindCategoryByIdOutputPort findCategoryByIdOutputPort;

    public FindCategoryByIdUseCase(FindCategoryByIdOutputPort findCategoryByIdOutputPort) {
        this.findCategoryByIdOutputPort = findCategoryByIdOutputPort;
    }

    @Override
    public Category find(Long id) throws NotFoundException {
        return findCategoryByIdOutputPort.find(id).orElseThrow(() -> new NotFoundException("Category not Found"));
    }
}
