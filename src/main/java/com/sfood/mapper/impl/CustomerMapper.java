package com.sfood.mapper.impl;

import com.sfood.dto.CustomerDTO;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper implements GenericMapper<CustomerEntity, CustomerDTO> {
    @Override
    public CustomerDTO toDTO(CustomerEntity entity) {
        LocalDate date = entity.getDateOfBirth();
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setName(entity.getName());
        dto.setDateOfBirth(date);
        return dto;
    }

    @Override
    public CustomerEntity toEntity(CustomerDTO dto) {
        LocalDate date = dto.getDateOfBirth();
        CustomerEntity entity = new CustomerEntity();
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setName(dto.getName());
        entity.setDateOfBirth(date);
        return entity;
    }
}
