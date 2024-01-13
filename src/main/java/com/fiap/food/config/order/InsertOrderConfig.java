package com.fiap.food.config.order;

import com.fiap.food.application.core.usecase.order.InsertOrderUseCase;
import com.fiap.food.application.ports.out.customer.FindCustomerByCpfOutputPort;
import com.fiap.food.application.ports.out.order.InsertOrderOutputPort;
import com.fiap.food.application.ports.out.product.FindProductByNameOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertOrderConfig {

    @Bean
    public InsertOrderUseCase insertOrderUseCase(
            FindCustomerByCpfOutputPort findCustomerByCpfOutputPort,
            FindProductByNameOutputPort findProductByNameOutputPort,
            InsertOrderOutputPort insertOrderOutputPort
    ) {
        return new InsertOrderUseCase(findCustomerByCpfOutputPort,findProductByNameOutputPort,insertOrderOutputPort);
    }
}
