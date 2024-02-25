package com.fiap.food.api.order.service;

import com.fiap.food.api.customer.service.CustomerService;
import com.fiap.food.api.order.mapper.OrderEntityMapper;
import com.fiap.food.api.product.mapper.ProductEntityMapper;
import com.fiap.food.api.product.service.ProductService;
import com.fiap.food.api.customer.dto.Customer;
import com.fiap.food.api.order.dto.Order;
import com.fiap.food.api.product.dto.Product;
import com.fiap.food.core.exception.NotFoundException;
import com.fiap.food.core.model.OrderEntity;
import com.fiap.food.core.repository.OrderRepository;
import com.fiap.food.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Override
    public List<Order> findAll() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream().map(orderEntityMapper::toOrder).toList();
    }

    @Override
    public Optional<Order> findByConfirmationCode(String confirmationCode) throws NotFoundException {
        var orderEntity = orderRepository.findByConfirmationCode(confirmationCode);
        return orderEntity.map(entity -> orderEntityMapper.toOrder(entity));
    }

    @Override
    public void insert(String cpfCustomer, List<String> productsName) throws NotFoundException {
        Order order = new Order();
        order.setDateTimeOrder(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        order.setConfirmationCode(UUID.randomUUID().toString());

        // Customer
        if (!Objects.isNull(cpfCustomer) && !cpfCustomer.isBlank()) {
            Optional<Customer> customer = customerService.findByCpf(cpfCustomer);
            customer.ifPresent(order::setCustomer);
        }

        // Product
        List<Product> products = new ArrayList<>();
        productsName.forEach(productName -> {
            Optional<Product> productOptional = productService.findByProductName(productName);
            productOptional.ifPresent(product -> {
                // Associando o produto à pedido
                product.setOrder(order);

                // Adicionando o produto à lista
                products.add(product);
            });
        });

        // Associando a lista de produtos à pedido
        order.setProducts(products);

        orderRepository.save(orderEntityMapper.toOrderEntity(order));
    }

    @Override
    public void updateConfirmOrder(Order order) throws NotFoundException {
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        orderRepository.save(orderEntity);
    }
}
