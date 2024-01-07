package com.fiap.food.config.customer;

import com.fiap.food.adapters.out.customer.FindCustomerByCpfAdapter;
import com.fiap.food.application.core.usecase.customer.FindCustomerByCpfUseCase;
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
