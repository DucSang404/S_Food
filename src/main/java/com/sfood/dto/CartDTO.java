package com.sfood.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDTO {
    private List<CartItemDTO> items = new ArrayList<>();

    private Long id;
    private CustomerDTO customer;
    private List<CartItemDTO> lstCartItem;

    public void addItem(CartItemDTO cartItemDTO) {
        for(CartItemDTO item : items) {
            if(item.getFood().getId().equals(cartItemDTO.getFood().getId())) {
                item.setQuantity(item.getQuantity() + cartItemDTO.getQuantity());
                return;
            }
        }
        items.add(cartItemDTO);
    }

    public Long getTotalItem() {
        return (long) items.size();
    }
}
