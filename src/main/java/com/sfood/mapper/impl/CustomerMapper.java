package com.sfood.mapper.impl;

import com.sfood.dto.CustomerDTO;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class CustomerMapper implements GenericMapper<CustomerEntity, CustomerDTO> {
    @Override
    public CustomerDTO toDTO(CustomerEntity entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setName(entity.getName());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setLoyaltyPoints(entity.getLoyaltyPoint());
        dto.setAvatar(entity.getAvatar());
        return dto;
    }

    @Override
    public CustomerEntity toEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setName(dto.getName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setLoyaltyPoint(dto.getLoyaltyPoints());
        entity.setAvatar(dto.getAvatar());
        return entity;
    }
}
