package com.fiap.food.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String name;
    @NotBlank
    private Double price;
    @NotBlank
    private String nameCategory;
    @NotBlank
    private String information;
    @Positive(message = "A quantidade deve ser maior que zero")
    private int quantity;
}
