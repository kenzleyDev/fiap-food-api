package com.fiap.food.config.category;

import com.fiap.food.application.core.usecase.category.FindCategoryByIdUseCase;
import com.fiap.food.application.core.usecase.category.FindCategoryByNameUseCase;
import com.fiap.food.application.ports.out.category.FindCategoryByIdOutputPort;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCategoryByIdConfig {

    @Bean
    public FindCategoryByIdUseCase findCategoryByIdUseCase(
            FindCategoryByIdOutputPort findCategoryByIdOutputPort
    ) {
        return new FindCategoryByIdUseCase(findCategoryByIdOutputPort);
    }
}
