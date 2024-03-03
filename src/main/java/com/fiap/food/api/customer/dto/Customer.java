package com.fiap.food.api.customer.dto;

import com.fiap.food.api.order.dto.Order;

import java.util.List;

public class Customer {

    public Customer() {
    }

    public Customer(Long id, String name, String cpf, String email, String password, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.orders = orders;
    }

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
