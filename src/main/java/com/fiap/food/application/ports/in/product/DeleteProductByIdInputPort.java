package com.fiap.food.application.ports.in.product;

import com.fiap.food.errors.exception.NotFoundException;

public interface DeleteProductByIdInputPort {

    void delete(Long id) throws NotFoundException;
}
