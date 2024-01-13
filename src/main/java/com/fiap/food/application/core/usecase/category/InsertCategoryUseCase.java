package com.fiap.food.application.core.usecase.category;

import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.InsertCategoryInputPort;
import com.fiap.food.application.ports.out.category.InsertCategoryOutputPort;

public class InsertCategoryUseCase implements InsertCategoryInputPort {

    private final InsertCategoryOutputPort insertCategoryOutputPort;

    public InsertCategoryUseCase(InsertCategoryOutputPort insertCategoryOutputPort) {
        this.insertCategoryOutputPort = insertCategoryOutputPort;
    }

    @Override
    public void insert(Category category) {
        insertCategoryOutputPort.insert(category);
    }
}
