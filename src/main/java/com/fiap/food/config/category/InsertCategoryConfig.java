package com.fiap.food.config.category;

import com.fiap.food.application.core.usecase.category.FindCategoryByNameUseCase;
import com.fiap.food.application.core.usecase.category.InsertCategoryUseCase;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import com.fiap.food.application.ports.out.category.InsertCategoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCategoryConfig {

    @Bean
    public InsertCategoryUseCase insertCategoryUseCase(
            InsertCategoryOutputPort insertCategoryOutputPort
    ) {
        return new InsertCategoryUseCase(insertCategoryOutputPort);
    }
}
