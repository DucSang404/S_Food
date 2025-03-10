package com.sfood.service.impl;

import com.sfood.dto.CartDTO;
import com.sfood.dto.CartItemDTO;
import com.sfood.dto.CustomerDTO;
import com.sfood.dto.FoodDTO;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.entity.cart.CartEntity;
import com.sfood.entity.cart.CartItemEntity;
import com.sfood.mapper.impl.CartMapper;
import com.sfood.repository.CartItemRepository;
import com.sfood.repository.CartRepository;
import com.sfood.repository.CustomerRepository;
import com.sfood.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private CartItemService cartItemService;


    public CartDTO findCartByCustomerId(Long customerId) {
        CartEntity cart = cartRepository.findOneByCustomerId(customerId);
        if(cart == null) {
            return null;
        }
        return cartMapper.toDTO(cart);
    }

    public void saveCartForCustomer(Long customerId, CartDTO cartFromCookie) {
        CustomerEntity customer = customerRepository.findById(customerId);

        CartEntity cart = customer.getCart();

        if(cart == null) {
            cart = new CartEntity();
            cart.setCustomer(customer);
            cart.setLstCartItem(new ArrayList<>());
        }

        for (CartItemDTO itemFromCookie : cartFromCookie.getLstCartItem()) {
            CartItemEntity existingItem = cart.getLstCartItem().stream()
                    .filter(item -> item.getFood().getId().equals(itemFromCookie.getFood().getId()))
                    .findFirst()
                    .orElse(null);

            if (existingItem != null) {
                existingItem.setQuantity(existingItem.getQuantity() + itemFromCookie.getQuantity());
            } else {
                CartItemEntity newItem = new CartItemEntity();
                newItem.setCart(cart);
                newItem.setFood(foodRepository.findById(itemFromCookie.getFood().getId()));
                newItem.setQuantity(itemFromCookie.getQuantity());
                cart.getLstCartItem().add(newItem);
            }
        }

        customer.setCart(cart);
        customerRepository.save(customer);
    }

    public CartItemDTO saveFoodInCart(FoodDTO food, Long quantity, Long cartId) {
        CartItemDTO cartItem = new CartItemDTO(null, food, quantity);
        return cartItemService.saveItems(cartItem, cartId);
    }

    public void removeFoodFromCart(Long foodId, Long cartId) {
        cartItemService.RemoveFoodItem(foodId, cartId);
    }

    public void updateFoodInCart(Long foodId, Long quantity, Long cartId) {
        cartItemService.updateFoodItem(foodId, quantity, cartId);
    }

    public CartDTO save(CartDTO cartDTO) {
        return cartMapper.toDTO(cartRepository.save(cartMapper.toEntity((cartDTO))));
    }

    public CartItemDTO getCartItemByFoodId(Long foodId) {
        return cartItemService.findByFoodId(foodId);
    }
}
