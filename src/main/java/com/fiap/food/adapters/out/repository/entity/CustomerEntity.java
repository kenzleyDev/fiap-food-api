package com.fiap.food.adapters.out.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Boolean isValidCpf;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;
}
