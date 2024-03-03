package com.fiap.food.core.model;

import com.fiap.food.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "`order`")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> products = new ArrayList<>();

    @Column(name = "date_time_order")
    private LocalDateTime dateTimeOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "confirmation_code")
    private String confirmationCode;

}
