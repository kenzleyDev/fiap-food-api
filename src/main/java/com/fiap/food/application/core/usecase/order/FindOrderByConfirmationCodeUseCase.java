package com.fiap.food.application.core.usecase.order;

import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.ports.in.order.FindOrderByConfirmationCodeInputPort;
import com.fiap.food.application.ports.out.order.FindOrderByConfirmationCodeOutputPort;
import com.fiap.food.errors.exception.NotFoundException;

public class FindOrderByConfirmationCodeUseCase implements FindOrderByConfirmationCodeInputPort {

    private final FindOrderByConfirmationCodeOutputPort findOrderByConfirmationCodeOutputPort;

    public FindOrderByConfirmationCodeUseCase(FindOrderByConfirmationCodeOutputPort findOrderByConfirmationCodeOutputPort) {
        this.findOrderByConfirmationCodeOutputPort = findOrderByConfirmationCodeOutputPort;
    }

    @Override
    public Order find(String confirmationCode) throws NotFoundException {
        return findOrderByConfirmationCodeOutputPort.find(confirmationCode)
                .orElseThrow(() -> new NotFoundException("Order not found"));
    }
}
