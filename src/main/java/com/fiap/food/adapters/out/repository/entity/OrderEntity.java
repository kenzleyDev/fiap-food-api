package com.fiap.food.adapters.out.repository.entity;

import com.fiap.food.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CustomerEntity customer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductEntity> products;
    @Column(name = "date_time_order")
    private LocalDateTime dateTimeOrder;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
