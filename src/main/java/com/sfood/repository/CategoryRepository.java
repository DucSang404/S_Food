package com.sfood.repository;

import com.sfood.entity.item.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findById(Long categoryId);
}
