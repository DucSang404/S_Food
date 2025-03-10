package com.sfood.service.impl;

import com.sfood.dto.CartDTO;
import com.sfood.dto.CartItemDTO;
import com.sfood.entity.cart.CartItemEntity;
import com.sfood.mapper.impl.CartItemMapper;
import com.sfood.repository.CartItemRepository;
import com.sfood.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    @Autowired
    private CartItemMapper cartItemMapper;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    public CartItemDTO saveItems(CartItemDTO cartItem, Long cartId) {
        CartItemEntity cartItemEntity = cartItemMapper.toEntity(cartItem);

        CartItemEntity cartItemCheck = cartItemRepository.findByFoodIdAndCartId(cartItemEntity.getFood().getId(), cartId);

        if(cartItemCheck != null) {
            cartItemCheck.setQuantity(cartItemCheck.getQuantity() + cartItemEntity.getQuantity());
            return cartItemMapper.toDTO(cartItemRepository.save(cartItemCheck));
        }
        else {
            cartItemEntity.setCart(cartRepository.findOne(cartId));
            return cartItemMapper.toDTO(cartItemRepository.save(cartItemEntity));
        }
    }

    public void RemoveFoodItem(Long foodId, Long cartId) {
        CartItemEntity cartItem = cartItemRepository.findByFoodIdAndCartId(foodId, cartId);
        cartItemRepository.delete(cartItem);
    }

    public void updateFoodItem(Long foodId, Long quantity, Long cartId) {
        CartItemEntity cartItem = cartItemRepository.findByFoodIdAndCartId(foodId, cartId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }

    public CartItemDTO findByFoodId(Long foodId) {
        return cartItemMapper.toDTO(cartItemRepository.findByFoodId(foodId));
    }

    public CartItemDTO findByCartItem(Long foodId, Long cartId) {
        return cartItemMapper.toDTO(cartItemRepository.findByFoodIdAndCartId(foodId, cartId));
    }
}
