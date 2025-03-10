package com.sfood.repository;

import com.sfood.entity.item.FoodEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    List<FoodEntity> findByCategoryCode(String categoryCode, Pageable pageable);
    List<FoodEntity> findByNameContainingIgnoreCaseAndCategoryCode(String foodName, String categoryCode, Pageable pageable);
    long countByCategoryCode(String categoryCode);
    long countByNameContainingIgnoreCase(String foodName);
    long countByNameContainingIgnoreCaseAndCategoryCode(String foodName, String categoryCode);
    List<FoodEntity> findByNameContainingIgnoreCase(String foodName, Pageable pageable);
    FoodEntity findById(Long id);
}
