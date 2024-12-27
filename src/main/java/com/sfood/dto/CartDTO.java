package com.sfood.dto;

import java.util.List;

public class CartDTO {
    private Long id;
    private CustomerDTO customer;
    private List<CartItemDTO> lstCartItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<CartItemDTO> getLstCartItem() {
        return lstCartItem;
    }

    public void setLstCartItem(List<CartItemDTO> lstCartItem) {
        this.lstCartItem = lstCartItem;
    }
}
