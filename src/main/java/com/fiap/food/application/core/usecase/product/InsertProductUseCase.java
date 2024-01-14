package com.fiap.food.application.core.usecase.product;

import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.in.product.InsertProductInputPort;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import com.fiap.food.application.ports.out.product.InsertProductOutputPort;

public class InsertProductUseCase implements InsertProductInputPort {

    private final FindCategoryByNameOutputPort findCategoryByNameOutputPort;

    private final InsertProductOutputPort insertProductOutputPort;

    public InsertProductUseCase(FindCategoryByNameOutputPort findCategoryByNameOutputPort,
                                InsertProductOutputPort insertProductOutputPort) {
        this.findCategoryByNameOutputPort = findCategoryByNameOutputPort;
        this.insertProductOutputPort = insertProductOutputPort;
    }

    @Override
    public void insert(Product product, String categoryName) {
        var category = findCategoryByNameOutputPort.find(categoryName);
        product.setCategory(category.get());
        insertProductOutputPort.insert(product);
    }
}
