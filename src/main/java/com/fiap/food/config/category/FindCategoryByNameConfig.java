package com.fiap.food.config.category;

import com.fiap.food.adapters.out.customer.FindCustomerByCpfAdapter;
import com.fiap.food.application.core.usecase.category.FindCategoryByNameUseCase;
import com.fiap.food.application.core.usecase.customer.FindCustomerByCpfUseCase;
import com.fiap.food.application.ports.out.category.FindCategoryByNameOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCategoryByNameConfig {

    @Bean
    public FindCategoryByNameUseCase findCategoryByNameUseCase(
            FindCategoryByNameOutputPort findCategoryByNameOutputPort
    ) {
        return new FindCategoryByNameUseCase(findCategoryByNameOutputPort);
    }
}
