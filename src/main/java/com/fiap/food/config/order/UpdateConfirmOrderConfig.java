package com.fiap.food.config.order;

import com.fiap.food.application.core.usecase.order.UpdateConfirmOrderUseCase;
import com.fiap.food.application.ports.in.order.FindOrderByConfirmationCodeInputPort;
import com.fiap.food.application.ports.out.order.UpdateConfirmOrderOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateConfirmOrderConfig {

    @Bean
    public UpdateConfirmOrderUseCase updateConfirmOrderUseCase(
            FindOrderByConfirmationCodeInputPort findOrderByConfirmationCodeInputPort,
            UpdateConfirmOrderOutputPort updateConfirmOrderOutputPort
    ) {
        return new UpdateConfirmOrderUseCase(findOrderByConfirmationCodeInputPort,updateConfirmOrderOutputPort);
    }
}
