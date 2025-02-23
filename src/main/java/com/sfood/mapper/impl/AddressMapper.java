package com.sfood.mapper.impl;

import com.sfood.dto.AddressDTO;
import com.sfood.entity.shipping.AddressEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements GenericMapper<AddressEntity, AddressDTO> {

    @Override
    public AddressDTO toDTO(AddressEntity entity) {
        AddressDTO dto = new AddressDTO();
        dto.setId(entity.getId());
        dto.setWard(entity.getWard());
        dto.setProvince(entity.getProvince());
        dto.setStreet(entity.getStreet());
        dto.setDistrict(entity.getDistrict());
        return dto;
    }

    @Override
    public AddressEntity toEntity(AddressDTO dto) {
        AddressEntity entity = new AddressEntity();
        entity.setId(dto.getId());
        entity.setWard(dto.getWard());
        entity.setProvince(dto.getProvince());
        entity.setStreet(dto.getStreet());
        entity.setDistrict(dto.getDistrict());
        return entity;
    }
}
