package com.fiap.food.config.product;

import com.fiap.food.application.core.usecase.product.InsertProductUseCase;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import com.fiap.food.application.ports.out.product.InsertProductOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertProductConfig {

    @Bean
    public InsertProductUseCase insertProductUseCase(
            FindCategoryByNameOutputPort findCategoryByNameOutputPort,
            InsertProductOutputPort insertProductOutputPort
    ) {
        return new InsertProductUseCase(findCategoryByNameOutputPort, insertProductOutputPort);
    }
}
