package com.sfood.mapper.impl;

import com.sfood.dto.CartDTO;
import com.sfood.entity.cart.CartEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper implements GenericMapper<CartEntity, CartDTO> {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CartItemMapper cartItemMapper;
    @Override
    public CartDTO toDTO(CartEntity entity) {
        CartDTO dto = new CartDTO();
        dto.setId(entity.getId());
        dto.setCustomer(customerMapper.toDTO(entity.getCustomer()));
        dto.setLstCartItem(cartItemMapper.toListDTO(entity.getLstCartItem()));
        return dto;
    }

    @Override
    public CartEntity toEntity(CartDTO dto) {
        CartEntity entity = new CartEntity();
        entity.setId(dto.getId());
        entity.setCustomer(customerMapper.toEntity(dto.getCustomer()));
        entity.setLstCartItem(cartItemMapper.toListEntity(dto.getLstCartItem()));
        return entity;
    }
}
