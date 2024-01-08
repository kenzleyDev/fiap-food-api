package com.fiap.food.application.core.usecase.product;

import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.in.product.FindProductByIdInputPort;
import com.fiap.food.application.ports.out.product.FindProductByIdOutputPort;

public class FindProductByIdUseCase implements FindProductByIdInputPort {

    private final FindProductByIdOutputPort findProductByIdOutputPort;

    public FindProductByIdUseCase(FindProductByIdOutputPort findProductByIdOutputPort) {
        this.findProductByIdOutputPort = findProductByIdOutputPort;
    }


    @Override
    public Product find(Long id) {
        return findProductByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("product not found"));
    }
}
