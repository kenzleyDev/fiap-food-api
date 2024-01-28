package com.fiap.food.application.core.domain;

public class Product {

    public Product() {
    }

    public Product(Long id, String name, Double price, Category category, String information, int quantity, Order order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.information = information;
        this.order = order;
    }

    private Long id;
    private String name;
    private Double price;
    private Category category;
    private String information;
    private int quantity;

    private Order order;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
