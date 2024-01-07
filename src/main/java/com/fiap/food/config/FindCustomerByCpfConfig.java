package com.fiap.food.config;

import com.fiap.food.adapters.out.FindCustomerByCpfAdapter;
import com.fiap.food.adapters.out.FindCustomerByIdAdapter;
import com.fiap.food.application.core.usecase.FindCustomerByCpfUseCase;
import com.fiap.food.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByCpfConfig {

    @Bean
    public FindCustomerByCpfUseCase findCustomerByCpfUseCase(
            FindCustomerByCpfAdapter findCustomerByCpfAdapter
    ) {
        return new FindCustomerByCpfUseCase(findCustomerByCpfAdapter);
    }
}
