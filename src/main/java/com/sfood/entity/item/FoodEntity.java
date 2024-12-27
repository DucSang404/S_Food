package com.sfood.entity.item;

import com.sfood.entity.cart.CartItemEntity;
import com.sfood.entity.discount.FoodDiscountEntity;
import com.sfood.entity.order.OrderDetailsEntity;
import com.sfood.enums.EnumFoodStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[food]")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Long price;

    @Column(name = "img_url")
    private String imgUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EnumFoodStatus status;

    @Column(name = "outstanding")
    private boolean outstanding;

    @Column(name = "new_release")
    private LocalDateTime newRelease;

    @OneToMany(mappedBy = "food")
    private List<CartItemEntity> lstCartItem = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "food")
    private List<OrderDetailsEntity> lstOrderDetails = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "food_discount_id", referencedColumnName = "id")
    private FoodDiscountEntity foodDiscount;

    public FoodDiscountEntity getFoodDiscount() {
        return foodDiscount;
    }

    public void setFoodDiscount(FoodDiscountEntity foodDiscount) {
        this.foodDiscount = foodDiscount;
    }

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

    public List<CartItemEntity> getLstCartItem() {
        return lstCartItem;
    }

    public void setLstCartItem(List<CartItemEntity> lstCartItem) {
        this.lstCartItem = lstCartItem;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<OrderDetailsEntity> getLstOrderDetails() {
        return lstOrderDetails;
    }

    public void setLstOrderDetails(List<OrderDetailsEntity> lstOrderDetails) {
        this.lstOrderDetails = lstOrderDetails;
    }
}
