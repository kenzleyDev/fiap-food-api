package com.fiap.food.config.order;


import com.fiap.food.application.core.usecase.order.FindAllOrdersUseCase;
import com.fiap.food.application.ports.out.order.FindAllOrdersOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllOrdersConfig {

    @Bean
    public FindAllOrdersUseCase findAllOrdersUseCase(FindAllOrdersOutputPort findAllOrdersOutputPort) {
        return new FindAllOrdersUseCase(findAllOrdersOutputPort);
    }
}
