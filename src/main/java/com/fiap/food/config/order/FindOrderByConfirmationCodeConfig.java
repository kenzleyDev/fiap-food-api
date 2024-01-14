package com.fiap.food.config.order;

import com.fiap.food.application.core.usecase.order.FindOrderByConfirmationCodeUseCase;
import com.fiap.food.application.ports.out.order.FindOrderByConfirmationCodeOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByConfirmationCodeConfig {

    @Bean
    public FindOrderByConfirmationCodeUseCase findOrderByConfirmationCodeUseCase(
            FindOrderByConfirmationCodeOutputPort findOrderByConfirmationCodeOutputPort){
        return new FindOrderByConfirmationCodeUseCase(findOrderByConfirmationCodeOutputPort);
    }
}
