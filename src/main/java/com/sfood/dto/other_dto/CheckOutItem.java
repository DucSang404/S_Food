package com.sfood.dto.other_dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckOutItem {
    private Long foodId;
    private Long quantity;
    private Long cartId;

}
