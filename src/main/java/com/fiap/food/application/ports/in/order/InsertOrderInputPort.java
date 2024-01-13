package com.fiap.food.application.ports.in.order;

import com.fiap.food.application.core.domain.Order;

import java.util.List;

public interface InsertOrderInputPort {
    void insert(String cpfCustomer, List<String> productsName);
}
