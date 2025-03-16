package com.sfood.mapper.impl;

import com.sfood.dto.OrderDetailsDTO;
import com.sfood.entity.order.OrderDetailsEntity;
import com.sfood.mapper.GenericMapper;
import com.sfood.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetailsMapper implements GenericMapper<OrderDetailsEntity, OrderDetailsDTO> {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public OrderDetailsDTO toDTO(OrderDetailsEntity entity) {
        OrderDetailsDTO dto = new OrderDetailsDTO();
        dto.setId(entity.getId());
        dto.setFood(foodMapper.toDTO(entity.getFood()));
        dto.setQuantity(entity.getQuantity());
        return dto;
    }

    @Override
    public OrderDetailsEntity toEntity(OrderDetailsDTO dto) {
        OrderDetailsEntity entity = new OrderDetailsEntity();
        entity.setId(dto.getId());
        entity.setFood(foodMapper.toEntity(dto.getFood()));
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

    public List<OrderDetailsDTO> toDTOList(List<OrderDetailsEntity> entities) {
        List<OrderDetailsDTO> dtos = new ArrayList<>();
        for(OrderDetailsEntity entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    public List<OrderDetailsEntity> toEntityList(List<OrderDetailsDTO> dtos) {
        List<OrderDetailsEntity> entities = new ArrayList<>();
        for(OrderDetailsDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}
