package com.fiap.food.adapters.out.repository;

import com.fiap.food.adapters.out.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.category.name = :categoryName")
    List<ProductEntity> findByCategoryName(@Param("categoryName") String categoryName);
}
