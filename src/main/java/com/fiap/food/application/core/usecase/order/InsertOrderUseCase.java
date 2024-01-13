package com.fiap.food.application.core.usecase.order;

import com.fiap.food.application.core.domain.Customer;
import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.in.order.InsertOrderInputPort;
import com.fiap.food.application.ports.out.order.InsertOrderOutputPort;
import com.fiap.food.application.ports.out.customer.FindCustomerByCpfOutputPort;
import com.fiap.food.application.ports.out.product.FindProductByIdOutputPort;
import com.fiap.food.application.ports.out.product.FindProductByNameOutputPort;
import com.fiap.food.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InsertOrderUseCase implements InsertOrderInputPort {

    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;
    private final FindProductByNameOutputPort findProductByNameOutputPort;
    private final InsertOrderOutputPort insertOrderOutputPort;

    public InsertOrderUseCase(
            FindCustomerByCpfOutputPort findCustomerByCpfOutputPort,
            FindProductByNameOutputPort findProductByNameOutputPort,
            InsertOrderOutputPort insertOrderOutputPort
    ) {
        this.findCustomerByCpfOutputPort = findCustomerByCpfOutputPort;
        this.findProductByNameOutputPort = findProductByNameOutputPort;
        this.insertOrderOutputPort = insertOrderOutputPort;
    }

    @Override
    public void insert(String cpfCustomer, List<String> productsName) {
        Order order = new Order();
        order.setDateTimeOrder(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        order.setConfirmationCode(UUID.randomUUID().toString());

        // Customer
        if (!cpfCustomer.isEmpty() && !cpfCustomer.isBlank()) {
            Optional<Customer> customer = findCustomerByCpfOutputPort.find(cpfCustomer);
            customer.ifPresent(order::setCustomer);
        }

        // Product
        List<Product> products = new ArrayList<>();
        productsName.forEach(productName -> {
            Optional<Product> productOptional = findProductByNameOutputPort.find(productName);
            productOptional.ifPresent(product -> {
                // Associando o produto à pedido
                product.setOrder(order);

                // Adicionando o produto à lista
                products.add(product);
            });
        });

        // Associando a lista de produtos à pedido
        order.setProducts(products);

        insertOrderOutputPort.insert(order);
    }

}
