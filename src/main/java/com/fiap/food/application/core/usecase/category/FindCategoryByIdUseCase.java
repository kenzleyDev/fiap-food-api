package com.fiap.food.application.core.usecase.category;

import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.out.category.FindCategoryByIdOutputPort;

public class FindCategoryByIdUseCase implements FindCategoryByIdInputPort {

    private final FindCategoryByIdOutputPort findCategoryByIdOutputPort;

    public FindCategoryByIdUseCase(FindCategoryByIdOutputPort findCategoryByIdOutputPort) {
        this.findCategoryByIdOutputPort = findCategoryByIdOutputPort;
    }

    @Override
    public Category find(Long id) {
        return findCategoryByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Category not Found"));
    }
}
