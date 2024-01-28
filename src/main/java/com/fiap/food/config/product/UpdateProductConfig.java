package com.fiap.food.config.product;

import com.fiap.food.application.core.usecase.product.UpdateProductUseCase;
import com.fiap.food.application.ports.in.category.FindCategoryByNameInputPort;
import com.fiap.food.application.ports.in.product.FindProductByIdInputPort;
import com.fiap.food.application.ports.out.product.UpdateProductOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateProductConfig {

    @Bean
    public UpdateProductUseCase updateProductUseCase(
            FindProductByIdInputPort findProductByIdInputPort,
            FindCategoryByNameInputPort findCategoryByNameInputPort,
            UpdateProductOutputPort updateProductOutputPort
    ) {
        return new UpdateProductUseCase(findProductByIdInputPort,findCategoryByNameInputPort,updateProductOutputPort);
    }
}
