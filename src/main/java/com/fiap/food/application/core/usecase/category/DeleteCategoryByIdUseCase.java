package com.fiap.food.application.core.usecase.category;

import com.fiap.food.application.ports.in.category.DeleteCategoryByIdInputPort;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.out.category.DeleteCategoryByIdOutputPort;

public class DeleteCategoryByIdUseCase implements DeleteCategoryByIdInputPort {

    private final FindCategoryByIdInputPort findCategoryByIdInputPort;
    private final DeleteCategoryByIdOutputPort deleteCategoryByIdOutputPort;

    public DeleteCategoryByIdUseCase(
            FindCategoryByIdInputPort findCategoryByIdInputPort,
            DeleteCategoryByIdOutputPort deleteCategoryByIdOutputPort) {
        this.findCategoryByIdInputPort = findCategoryByIdInputPort;
        this.deleteCategoryByIdOutputPort = deleteCategoryByIdOutputPort;
    }

    @Override
    public void delete(Long id) {
        findCategoryByIdInputPort.find(id);
        deleteCategoryByIdOutputPort.delete(id);
    }
}
