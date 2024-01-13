package com.fiap.food.application.core.usecase.category;

import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.in.category.UpdateCategoryInputPort;
import com.fiap.food.application.ports.out.category.UpdateCategoryOutputPort;

public class UpdateCategoryUseCase implements UpdateCategoryInputPort {

    private final FindCategoryByIdInputPort findCategoryByIdInputPort;

    private final UpdateCategoryOutputPort updateCategoryOutputPort;

    public UpdateCategoryUseCase(FindCategoryByIdInputPort findCategoryByIdInputPort,
                                 UpdateCategoryOutputPort updateCategoryOutputPort) {
        this.findCategoryByIdInputPort = findCategoryByIdInputPort;
        this.updateCategoryOutputPort = updateCategoryOutputPort;
    }

    @Override
    public void update(Category category) {
        findCategoryByIdInputPort.find(category.getId());
        updateCategoryOutputPort.update(category);
    }
}
