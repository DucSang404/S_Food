package com.sfood.entity.cart;

import com.sfood.entity.actor.CustomerEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[cart]")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "cart")
    private List<CartItemEntity> lstCartItem = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<CartItemEntity> getLstCartItem() {
        return lstCartItem;
    }

    public void setLstCartItem(List<CartItemEntity> lstCartItem) {
        this.lstCartItem = lstCartItem;
    }
}
