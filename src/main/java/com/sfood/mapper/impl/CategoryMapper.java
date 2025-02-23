package com.sfood.mapper.impl;

import com.sfood.dto.CategoryDTO;
import com.sfood.entity.item.CategoryEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements GenericMapper<CategoryEntity, CategoryDTO> {

    @Override
    public CategoryDTO toDTO(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public CategoryEntity toEntity(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setId(dto.getId());
        return entity;
    }
}
