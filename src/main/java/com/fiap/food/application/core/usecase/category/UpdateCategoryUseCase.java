package com.fiap.food.application.core.usecase.category;

import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.in.category.UpdateCategoryInputPort;
import com.fiap.food.application.ports.out.category.UpdateCategoryOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class UpdateCategoryUseCase implements UpdateCategoryInputPort {

    private final FindCategoryByIdInputPort findCategoryByIdInputPort;

    private final UpdateCategoryOutputPort updateCategoryOutputPort;

    public UpdateCategoryUseCase(FindCategoryByIdInputPort findCategoryByIdInputPort,
                                 UpdateCategoryOutputPort updateCategoryOutputPort) {
        this.findCategoryByIdInputPort = findCategoryByIdInputPort;
        this.updateCategoryOutputPort = updateCategoryOutputPort;
    }

    @Override
    public void update(Category category) throws NotFoundException {
        findCategoryByIdInputPort.find(category.getId());
        updateCategoryOutputPort.update(category);
    }
}
