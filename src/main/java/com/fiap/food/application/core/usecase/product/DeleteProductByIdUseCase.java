package com.fiap.food.application.core.usecase.product;

import com.fiap.food.application.ports.in.product.DeleteProductByIdInputPort;
import com.fiap.food.application.ports.in.product.FindProductByIdInputPort;
import com.fiap.food.application.ports.out.product.DeleteProductByIdOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class DeleteProductByIdUseCase implements DeleteProductByIdInputPort {

    private final FindProductByIdInputPort findProductByIdInputPort;

    private final DeleteProductByIdOutputPort deleteProductByIdOutputPort;

    public DeleteProductByIdUseCase(FindProductByIdInputPort findProductByIdInputPort, DeleteProductByIdOutputPort deleteProductByIdOutputPort) {
        this.findProductByIdInputPort = findProductByIdInputPort;
        this.deleteProductByIdOutputPort = deleteProductByIdOutputPort;
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        findProductByIdInputPort.find(id);
        deleteProductByIdOutputPort.delete(id);

    }
}
