package com.sfood.entity.discount;

import com.sfood.entity.item.FoodEntity;

import javax.persistence.*;

@Entity
@Table(name = "[food_discount]")
public class FoodDiscountEntity extends DiscountEntity{
    @OneToOne(mappedBy = "foodDiscount")
    private FoodEntity food;

    public FoodEntity getFood() {
        return food;
    }

    public void setFood(FoodEntity food) {
        this.food = food;
    }
}
