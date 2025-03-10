package com.sfood.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class DiscountDTO {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int outstanding;
    private Long discountPercentage;

}
