package com.sfood.mapper.impl;

import com.sfood.dto.BillDiscountDTO;
import com.sfood.entity.discount.BillDiscountEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class BillDiscountMapper implements GenericMapper<BillDiscountEntity, BillDiscountDTO> {
    @Override
    public BillDiscountDTO toDTO(BillDiscountEntity entity) {
        BillDiscountDTO dto = new BillDiscountDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setLoyaltyPointsRequired(entity.getLoyaltyPointsRequired());
        dto.setMinimumInvoiceAmount(entity.getMinimumInvoiceAmount());
        dto.setOutstanding(entity.isOutstanding());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setName(entity.getName());
        dto.setDiscountPercentage(entity.getDiscountPercentage());

        return dto;
    }

    @Override
    public BillDiscountEntity toEntity(BillDiscountDTO dto) {
        BillDiscountEntity entity = new BillDiscountEntity();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setLoyaltyPointsRequired(dto.getLoyaltyPointsRequired());
        entity.setMinimumInvoiceAmount(dto.getMinimumInvoiceAmount());
        entity.setOutstanding(dto.getOutstanding());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setName(dto.getName());
        entity.setDiscountPercentage(dto.getDiscountPercentage());

        return entity;
    }
}
