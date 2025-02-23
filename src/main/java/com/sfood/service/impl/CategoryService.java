package com.sfood.service.impl;

import com.sfood.dto.CategoryDTO;
import com.sfood.entity.item.CategoryEntity;
import com.sfood.mapper.impl.CategoryMapper;
import com.sfood.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> findAllCategory() {
        List<CategoryDTO> dtos = new ArrayList<>();
        List<CategoryEntity> entities = categoryRepository.findAll();
        for (CategoryEntity entity : entities) {
            dtos.add(categoryMapper.toDTO(entity));
        }
        return dtos;
    }
    public CategoryEntity findById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
