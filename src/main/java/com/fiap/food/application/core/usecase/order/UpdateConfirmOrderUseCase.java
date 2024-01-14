package com.fiap.food.application.core.usecase.order;

import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.ports.in.order.FindOrderByConfirmationCodeInputPort;
import com.fiap.food.application.ports.in.order.UpdateConfirmOrderInputPort;
import com.fiap.food.application.ports.out.order.UpdateConfirmOrderOutputPort;
import com.fiap.food.enums.OrderStatus;

public class UpdateConfirmOrderUseCase implements UpdateConfirmOrderInputPort {

    private final FindOrderByConfirmationCodeInputPort findOrderByConfirmationCodeInputPort;

    private final UpdateConfirmOrderOutputPort updateConfirmOrderOutputPort;

    public UpdateConfirmOrderUseCase(
            FindOrderByConfirmationCodeInputPort findOrderByConfirmationCodeInputPort,
            UpdateConfirmOrderOutputPort updateConfirmOrderOutputPort
    ) {
        this.findOrderByConfirmationCodeInputPort = findOrderByConfirmationCodeInputPort;
        this.updateConfirmOrderOutputPort = updateConfirmOrderOutputPort;
    }

    @Override
    public void update(Order order) {
        findOrderByConfirmationCodeInputPort.find(order.getConfirmationCode());
        order.setStatus(OrderStatus.CONFIRMED);
        updateConfirmOrderOutputPort.update(order);
    }
}
