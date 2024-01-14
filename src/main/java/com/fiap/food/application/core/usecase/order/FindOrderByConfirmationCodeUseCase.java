package com.fiap.food.application.core.usecase.order;

import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.ports.in.order.FindOrderByConfirmationCodeInputPort;
import com.fiap.food.application.ports.out.order.FindOrderByConfirmationCodeOutputPort;

public class FindOrderByConfirmationCodeUseCase implements FindOrderByConfirmationCodeInputPort {

    private final FindOrderByConfirmationCodeOutputPort findOrderByConfirmationCodeOutputPort;

    public FindOrderByConfirmationCodeUseCase(FindOrderByConfirmationCodeOutputPort findOrderByConfirmationCodeOutputPort) {
        this.findOrderByConfirmationCodeOutputPort = findOrderByConfirmationCodeOutputPort;
    }

    @Override
    public Order find(String confirmationCode) {
        return findOrderByConfirmationCodeOutputPort.find(confirmationCode)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
