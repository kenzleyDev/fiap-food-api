package com.fiap.food.application.core.usecase.product;

import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.in.product.FindProductByIdInputPort;
import com.fiap.food.application.ports.out.product.FindProductByIdOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class FindProductByIdUseCase implements FindProductByIdInputPort {

    private final FindProductByIdOutputPort findProductByIdOutputPort;

    public FindProductByIdUseCase(FindProductByIdOutputPort findProductByIdOutputPort) {
        this.findProductByIdOutputPort = findProductByIdOutputPort;
    }


    @Override
    public Product find(Long id) throws NotFoundException {
        return findProductByIdOutputPort.find(id)
                .orElseThrow(() -> new NotFoundException("product not found"));
    }
}
