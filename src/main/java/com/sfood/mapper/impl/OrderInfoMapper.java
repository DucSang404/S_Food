package com.sfood.mapper.impl;

import com.sfood.dto.OrderInfoDTO;
import com.sfood.entity.shipping.OrderInfoEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderInfoMapper implements GenericMapper<OrderInfoEntity, OrderInfoDTO> {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public OrderInfoDTO toDTO(OrderInfoEntity entity) {
        OrderInfoDTO dto = new OrderInfoDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setAddress(addressMapper.toDTO(entity.getAddress()));
        dto.setDefault(entity.isDefault());
        dto.setRecipient(entity.getRecipient());
        return dto;
    }

    @Override
    public OrderInfoEntity toEntity(OrderInfoDTO dto) {
        OrderInfoEntity entity = new OrderInfoEntity();
        entity.setId(dto.getId());
        entity.setPhone(dto.getPhone());
        entity.setAddress(addressMapper.toEntity(dto.getAddress()));
        entity.setDefault(dto.isDefault());
        entity.setRecipient(dto.getRecipient());
        return entity;
    }
}
