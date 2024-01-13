package com.fiap.food.config.product;

import com.fiap.food.application.core.usecase.product.FindProductByNameUseCase;
import com.fiap.food.application.ports.out.product.FindProductByNameOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByNameConfig {

    @Bean
    public FindProductByNameUseCase findProductByNameUseCase(
            FindProductByNameOutputPort findProductByNameOutputPort
    ) {
        return new FindProductByNameUseCase(findProductByNameOutputPort);
    }
}
