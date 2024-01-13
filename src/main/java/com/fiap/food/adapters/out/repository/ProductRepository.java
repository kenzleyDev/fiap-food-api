package com.fiap.food.adapters.out.repository;

import com.fiap.food.adapters.out.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE LOWER(p.category.name) LIKE LOWER(concat('%', :categoryName, '%'))")
    List<ProductEntity> findByCategoryName(@Param("categoryName") String categoryName);

    Optional<ProductEntity> findByName(String name);
}
