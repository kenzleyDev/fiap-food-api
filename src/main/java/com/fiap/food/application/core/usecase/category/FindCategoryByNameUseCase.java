package com.fiap.food.application.core.usecase.category;

import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.FindCategoryByNameInputPort;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class FindCategoryByNameUseCase implements FindCategoryByNameInputPort {

    private final FindCategoryByNameOutputPort findCategoryByNameOutputPort;

    public FindCategoryByNameUseCase(FindCategoryByNameOutputPort findCategoryByNameOutputPort) {
        this.findCategoryByNameOutputPort = findCategoryByNameOutputPort;
    }

    @Override
    public Category find(String categoryName) throws NotFoundException {
        return findCategoryByNameOutputPort.find(categoryName).orElseThrow(() -> new NotFoundException("Category not Found"));
    }
}
