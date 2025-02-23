package com.sfood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class CartItemDTO {
    private Long id;
    private FoodDTO food;
    private Long quantity;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFood(FoodDTO food) {
        this.food = food;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
