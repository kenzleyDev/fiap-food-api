package com.fiap.food.adapters.in.controller.response;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private CategoryResponse category;
    private String information;
    private int quantity;
}
