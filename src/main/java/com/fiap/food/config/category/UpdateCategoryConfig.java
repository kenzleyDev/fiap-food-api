package com.fiap.food.config.category;

import com.fiap.food.application.core.usecase.category.InsertCategoryUseCase;
import com.fiap.food.application.core.usecase.category.UpdateCategoryUseCase;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.out.category.InsertCategoryOutputPort;
import com.fiap.food.application.ports.out.category.UpdateCategoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCategoryConfig {

    @Bean
    public UpdateCategoryUseCase updateCategoryUseCase(
            FindCategoryByIdInputPort findCategoryByIdInputPort,
            UpdateCategoryOutputPort updateCategoryOutputPort
    ) {
        return new UpdateCategoryUseCase(findCategoryByIdInputPort, updateCategoryOutputPort);
    }
}
