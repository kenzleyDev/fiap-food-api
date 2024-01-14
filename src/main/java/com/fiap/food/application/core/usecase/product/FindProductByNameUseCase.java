package com.fiap.food.application.core.usecase.product;

import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.in.product.FindProductByNameInputPort;
import com.fiap.food.application.ports.out.product.FindProductByNameOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class FindProductByNameUseCase implements FindProductByNameInputPort {

    private final FindProductByNameOutputPort findProductByNameOutputPort;

    public FindProductByNameUseCase(FindProductByNameOutputPort findProductByNameOutputPort) {
        this.findProductByNameOutputPort = findProductByNameOutputPort;
    }

    @Override
    public Product find(String productName) throws NotFoundException {
        return findProductByNameOutputPort.find(productName)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }
}
