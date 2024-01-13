package com.fiap.food.application.core.domain;

import com.fiap.food.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    public Order(Long id, Customer customer, List<Product> products, LocalDateTime dateTimeOrder, Double amount, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.dateTimeOrder = dateTimeOrder;
        this.amount = amount;
        this.status = status;
    }

    public Order() {
    }
    private Long id;
    private Customer customer;
    private List<Product> products;
    private LocalDateTime dateTimeOrder;
    private Double amount;
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(LocalDateTime dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
