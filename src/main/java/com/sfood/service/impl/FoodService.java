package com.sfood.service.impl;

import com.sfood.dto.FoodDTO;
import com.sfood.entity.item.FoodEntity;
import com.sfood.mapper.impl.FoodMapper;
import com.sfood.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodMapper foodMapper;

    public void saveFood(FoodEntity foodEntity) {
        foodRepository.save(foodEntity);
    }

    public List<FoodDTO> findAllFood() {
        List<FoodDTO> lstFood = new ArrayList<>();
        List<FoodEntity> lstFoodEntity = foodRepository.findAll();
        for (FoodEntity entity : lstFoodEntity) {
            lstFood.add(foodMapper.toDTO(entity));
        }
        return lstFood;
    }

    public List<FoodDTO> findAllFood(String foodName, Pageable pageable) {
        List<FoodDTO> lstFood = new ArrayList<>();
        List<FoodEntity> lstFoodEntity = new ArrayList<>();
        if(!Objects.equals(foodName, "")) {
            lstFoodEntity = foodRepository.findByNameContainingIgnoreCase(foodName, pageable);
        }
        else {
            lstFoodEntity = foodRepository.findAll(pageable).getContent();
        }
        for (FoodEntity entity : lstFoodEntity) {
            lstFood.add(foodMapper.toDTO(entity));
        }
        return lstFood;
    }

    public int totalItem(String foodName, String categoryCode) {
        if ("all".equals(categoryCode)) {
            if(!Objects.equals(foodName, "")) {
                return (int) foodRepository.countByNameContainingIgnoreCase(foodName);
            } else {
                return (int) foodRepository.count();
            }
        } else {
            if(!Objects.equals(foodName, "")) {
                return (int) foodRepository.countByNameContainingIgnoreCaseAndCategoryCode(foodName, categoryCode);
            } else {
                return (int) foodRepository.countByCategoryCode(categoryCode);
            }
        }
    }


    public List<FoodDTO> findFoodByNameAndCategory(String foodName, String categoryCode, Pageable pageable) {
        List<FoodEntity> entities = new ArrayList<>();
        if(!Objects.equals(foodName, "")) {
            entities = foodRepository.findByNameContainingIgnoreCaseAndCategoryCode(foodName, categoryCode, pageable);
        }
        else {
            entities = foodRepository.findByCategoryCode(categoryCode, pageable);
        }
        List<FoodDTO> dtos = new ArrayList<>();
        for(FoodEntity entity : entities) {
            dtos.add(foodMapper.toDTO(entity));
        }
        return dtos;
    }

    public FoodDTO findFoodById(Long id) {
        return foodMapper.toDTO(foodRepository.findOne(id));
    }
}