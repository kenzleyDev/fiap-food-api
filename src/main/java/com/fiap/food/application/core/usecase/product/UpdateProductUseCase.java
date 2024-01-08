package com.fiap.food.application.core.usecase.product;

import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.in.category.FindCategoryByNameInputPort;
import com.fiap.food.application.ports.in.product.FindProductByIdInputPort;
import com.fiap.food.application.ports.in.product.UpdateProductInputPort;
import com.fiap.food.application.ports.out.product.UpdateProductOutputPort;

public class UpdateProductUseCase implements UpdateProductInputPort {

    private final FindProductByIdInputPort findProductByIdInputPort;
    private final FindCategoryByNameInputPort findCategoryByNameInputPort;

    private final UpdateProductOutputPort updateProductOutputPort;

    public UpdateProductUseCase(FindProductByIdInputPort findProductByIdInputPort,
                                FindCategoryByNameInputPort findCategoryByNameInputPort,
                                UpdateProductOutputPort updateProductOutputPort) {
        this.findProductByIdInputPort = findProductByIdInputPort;
        this.findCategoryByNameInputPort = findCategoryByNameInputPort;
        this.updateProductOutputPort = updateProductOutputPort;
    }

    @Override
    public void update(Product product, String categoryName) {
        findProductByIdInputPort.find(product.getId());
        var category = findCategoryByNameInputPort.find(categoryName);
        product.setCategory(category);
        updateProductOutputPort.update(product);
    }
}
