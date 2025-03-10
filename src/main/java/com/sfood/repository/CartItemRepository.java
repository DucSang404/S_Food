package com.sfood.repository;

import com.sfood.entity.cart.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {
    void deleteByFoodIdAndCartId(Long foodId, Long cartId);
    CartItemEntity findByFoodIdAndCartId(Long foodId, Long cartId);
    CartItemEntity findByFoodId(Long foodId);
}