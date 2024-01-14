package com.fiap.food.application.core.usecase.product;

import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.in.product.FindProductByCategoryNameInputPort;
import com.fiap.food.application.ports.out.product.FindProductByCategoryNameOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

import java.util.List;

public class FindProductByCategoryNameUseCase implements FindProductByCategoryNameInputPort {

    private final FindProductByCategoryNameOutputPort findProductByCategoryNameOutputPort;

    public FindProductByCategoryNameUseCase(FindProductByCategoryNameOutputPort findProductByCategoryNameOutputPort) {
        this.findProductByCategoryNameOutputPort = findProductByCategoryNameOutputPort;
    }

    @Override
    public List<Product> find(String categoryName) throws NotFoundException {
        List<Product> products = findProductByCategoryNameOutputPort.find(categoryName);
        if (products.isEmpty()) {
            throw new NotFoundException("No products found for the category: " + categoryName);
        }
        return products;

    }
}
