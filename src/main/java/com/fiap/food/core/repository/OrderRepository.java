package com.fiap.food.core.repository;

import com.fiap.food.core.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByConfirmationCode(String confirmationCode);
}
