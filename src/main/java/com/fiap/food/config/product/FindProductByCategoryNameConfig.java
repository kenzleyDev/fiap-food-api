package com.fiap.food.config.product;

import com.fiap.food.application.core.usecase.product.FindProductByCategoryNameUseCase;
import com.fiap.food.application.core.usecase.product.FindProductByIdUseCase;
import com.fiap.food.application.ports.out.product.FindProductByCategoryNameOutputPort;
import com.fiap.food.application.ports.out.product.FindProductByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByCategoryNameConfig {
    @Bean
    public FindProductByCategoryNameUseCase findProductByCategoryNameUseCase(
            FindProductByCategoryNameOutputPort findProductByCategoryNameOutputPort
    ) {
        return new FindProductByCategoryNameUseCase(findProductByCategoryNameOutputPort);
    }
}
