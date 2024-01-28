package com.fiap.food.adapters.out.repository;

import com.fiap.food.adapters.out.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByConfirmationCode(String confirmationCode);
}
