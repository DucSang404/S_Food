package com.sfood.mapper.impl;

import com.sfood.dto.FoodDTO;
import com.sfood.entity.item.FoodEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper implements GenericMapper<FoodEntity, FoodDTO> {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public FoodDTO toDTO(FoodEntity entity) {
        FoodDTO dto = new FoodDTO();
        dto.setCategory(categoryMapper.toDTO(entity.getCategory()));
        dto.setName(entity.getName());
        dto.setImgUrl(entity.getImgUrl());
        dto.setPrice(entity.getPrice());
        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setDescription(entity.getDescription());
        dto.setNewRelease(entity.getNewRelease());
        dto.setOutstanding(entity.isOutstanding());
        return dto;
    }

    @Override
    public FoodEntity toEntity(FoodDTO dto) {
        FoodEntity entity = new FoodEntity();
        entity.setCategory(categoryMapper.toEntity(dto.getCategory()));
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPrice(dto.getPrice());
        entity.setId(dto.getId());
        entity.setStatus(dto.getStatus());
        entity.setDescription(dto.getDescription());
        entity.setNewRelease(dto.getNewRelease());
        entity.setOutstanding(dto.isOutstanding());
        return entity;
    }
}
