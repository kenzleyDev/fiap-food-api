package com.fiap.food.api.order.service;

import com.fiap.food.api.order.dto.Order;
import com.fiap.food.core.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findByConfirmationCode(String confirmationCode) throws NotFoundException;
    void insert(String cpfCustomer, List<String> productsName) throws NotFoundException;
    void updateConfirmOrder(Order order) throws NotFoundException;
}
