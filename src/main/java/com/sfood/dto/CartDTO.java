package com.sfood.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDTO {

    private Long id;
    private CustomerDTO customer;
    private List<CartItemDTO> lstCartItem = new ArrayList<>();
    private Long totalItem;

    public void addItem(CartItemDTO cartItemDTO) {
        for(CartItemDTO item : lstCartItem) {
            if(item.getFood().getId().equals(cartItemDTO.getFood().getId())) {
                item.setQuantity(item.getQuantity() + cartItemDTO.getQuantity());
                return;
            }
        }
        lstCartItem.add(cartItemDTO);
    }

    public Long getTotalItem() {
        return (long) lstCartItem.size();
    }
}
