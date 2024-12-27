package com.sfood.mapper.impl;

import com.sfood.dto.SocialAccountDTO;
import com.sfood.entity.account.SocialAccountEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class SocialAccountMapper implements GenericMapper<SocialAccountEntity, SocialAccountDTO> {

    @Override
    public SocialAccountDTO toDTO(SocialAccountEntity entity) {
        SocialAccountDTO dto = new SocialAccountDTO();
        dto.setStatus(entity.getStatus());
        dto.setId(entity.getId());
        dto.setFbID(entity.getFbId());
        dto.setGgID(entity.getGgId());
        return dto;
    }

    @Override
    public SocialAccountEntity toEntity(SocialAccountDTO dto) {
        SocialAccountEntity entity = new SocialAccountEntity();
        entity.setStatus(dto.getStatus());
        entity.setId(dto.getId());
        entity.setFbId(dto.getFbID());
        entity.setGgId(dto.getGgID());
        return entity;
    }
}
