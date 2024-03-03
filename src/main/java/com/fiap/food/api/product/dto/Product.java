package com.fiap.food.api.product.dto;

import com.fiap.food.api.category.dto.Category;
import com.fiap.food.api.order.dto.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String name;
    private Double price;
    private Category category;
    private String information;
    private Order order;
}
