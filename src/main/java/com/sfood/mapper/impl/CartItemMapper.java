package com.sfood.mapper.impl;

import com.sfood.dto.CartItemDTO;
import com.sfood.entity.cart.CartItemEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartItemMapper implements GenericMapper<CartItemEntity, CartItemDTO> {

    @Autowired
    private FoodMapper foodMapper;
    @Override
    public CartItemDTO toDTO(CartItemEntity entity) {
        CartItemDTO dto = new CartItemDTO();
        dto.setQuantity(entity.getQuantity());
        dto.setId(entity.getId());
        dto.setFood(foodMapper.toDTO(entity.getFood()));
        return dto;
    }

    @Override
    public CartItemEntity toEntity(CartItemDTO dto) {
        CartItemEntity entity = new CartItemEntity();
        entity.setQuantity(dto.getQuantity());
        entity.setId(dto.getId());
        entity.setFood(foodMapper.toEntity(dto.getFood()));
        return entity;
    }

    public List<CartItemEntity> toListEntity(List<CartItemDTO> dtos) {
        List<CartItemEntity> entities = new ArrayList<>();
        for(CartItemDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }

    public List<CartItemDTO> toListDTO(List<CartItemEntity> entities) {
        List<CartItemDTO> dtos = new ArrayList<>();
        for(CartItemEntity entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }
}
