package com.fiap.food.config.category;

import com.fiap.food.application.core.usecase.category.DeleteCategoryByIdUseCase;
import com.fiap.food.application.core.usecase.category.FindCategoryByNameUseCase;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.out.category.DeleteCategoryByIdOutputPort;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCategoryByIdConfig {

    @Bean
    public DeleteCategoryByIdUseCase deleteCategoryByIdUseCase(
            FindCategoryByIdInputPort findCategoryByIdInputPort,
            DeleteCategoryByIdOutputPort deleteCategoryByIdOutputPort
    ) {
        return new DeleteCategoryByIdUseCase(findCategoryByIdInputPort,deleteCategoryByIdOutputPort);
    }
}
