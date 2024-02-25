package com.fiap.food.api.order.dto;

import com.fiap.food.api.customer.dto.Customer;
import com.fiap.food.api.product.dto.Product;
import com.fiap.food.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Order {


    public Order(Long id, Customer customer, List<Product> products, LocalDateTime dateTimeOrder, OrderStatus status, String confirmationCode) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.dateTimeOrder = dateTimeOrder;
        this.status = status;
        this.confirmationCode = confirmationCode;
    }

    public Order() {
    }
    private Long id;
    private Customer customer;
    private List<Product> products;
    private LocalDateTime dateTimeOrder;
    private OrderStatus status;
    private String confirmationCode;

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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
