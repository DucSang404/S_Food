package com.sfood.dto;

public class FoodDiscountDTO extends DiscountDTO{
    private FoodDTO food;

    public FoodDTO getFood() {
        return food;
    }

    public void setFood(FoodDTO food) {
        this.food = food;
    }
}
