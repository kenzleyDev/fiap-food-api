package com.fiap.food.adapters.out.repository;

import com.fiap.food.adapters.out.repository.entity.CategoryEntity;
import com.fiap.food.application.core.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
     Optional<CategoryEntity> findByName(String name);
}
