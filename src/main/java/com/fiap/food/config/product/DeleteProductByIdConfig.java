package com.fiap.food.config.product;

import com.fiap.food.application.core.usecase.product.DeleteProductByIdUseCase;
import com.fiap.food.application.core.usecase.product.FindProductByIdUseCase;
import com.fiap.food.application.ports.in.product.FindProductByIdInputPort;
import com.fiap.food.application.ports.out.product.DeleteProductByIdOutputPort;
import com.fiap.food.application.ports.out.product.FindProductByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteProductByIdConfig {

    @Bean
    public DeleteProductByIdUseCase deleteProductByIdUseCase(
            FindProductByIdInputPort findProductByIdInputPort,
            DeleteProductByIdOutputPort deleteProductByIdOutputPort
    ) {
        return new DeleteProductByIdUseCase(findProductByIdInputPort,deleteProductByIdOutputPort);
    }
}
