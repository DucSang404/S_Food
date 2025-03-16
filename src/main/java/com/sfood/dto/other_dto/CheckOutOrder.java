package com.sfood.dto.other_dto;

import com.sfood.dto.CartItemDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CheckOutOrder {
    private Long orderInfoId;
    private Long billDiscountId;
    private String paymentMethod;
    private List<CartItemDTO> cartItems;
    private List<Long> foodIdList;
    private Long cartId;
}
