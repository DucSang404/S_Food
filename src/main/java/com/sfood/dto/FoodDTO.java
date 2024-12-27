package com.sfood.dto;

import com.sfood.enums.EnumFoodStatus;

import java.time.LocalDateTime;

public class FoodDTO {
    private Long id;
    private String name;
    private String description;
    private CategoryDTO category;
    private Long price;
    private String imgUrl;
    private EnumFoodStatus status;
    private boolean outstanding;
    private LocalDateTime newRelease;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public EnumFoodStatus getStatus() {
        return status;
    }

    public void setStatus(EnumFoodStatus status) {
        this.status = status;
    }

    public boolean isOutstanding() {
        return outstanding;
    }

    public void setOutstanding(boolean outstanding) {
        this.outstanding = outstanding;
    }

    public LocalDateTime getNewRelease() {
        return newRelease;
    }

    public void setNewRelease(LocalDateTime newRelease) {
        this.newRelease = newRelease;
    }
}
