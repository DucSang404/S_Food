package com.sfood.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDiscountDTO extends DiscountDTO{
    private String code;
    private Long loyaltyPointsRequired;
    private Long minimumInvoiceAmount;

}
