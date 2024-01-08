package com.fiap.food.application.core.usecase.category;

import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.FindCategoryByNameInputPort;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;

public class FindCategoryByNameUseCase implements FindCategoryByNameInputPort {

    private final FindCategoryByNameOutputPort findCategoryByNameOutputPort;

    public FindCategoryByNameUseCase(FindCategoryByNameOutputPort findCategoryByNameOutputPort) {
        this.findCategoryByNameOutputPort = findCategoryByNameOutputPort;
    }

    @Override
    public Category find(String categoryName) {
        return findCategoryByNameOutputPort.find(categoryName);
    }
}
