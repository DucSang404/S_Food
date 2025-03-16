package com.sfood.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderDTO {
    private Long id;
    private List<OrderStatusDTO> lstStatus;
    private List<OrderDetailsDTO> lstOrderDetails;
    private String paymentMethod;
    private Long billDiscountId;
    private Long orderInfoId;
}
