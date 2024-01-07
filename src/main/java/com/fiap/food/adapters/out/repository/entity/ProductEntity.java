package com.fiap.food.adapters.out.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    private String information;
    private int quantity;
}