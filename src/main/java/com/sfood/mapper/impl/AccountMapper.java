package com.sfood.mapper.impl;

import com.sfood.dto.AccountDTO;
import com.sfood.entity.account.AccountEntity;
import com.sfood.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements GenericMapper<AccountEntity, AccountDTO> {

    @Override
    public AccountDTO toDTO(AccountEntity entity) {
        AccountDTO dto = new AccountDTO();
        dto.setPassword(entity.getPassword());
        dto.setUsername(entity.getUsername());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    @Override
    public AccountEntity toEntity(AccountDTO dto) {
        AccountEntity entity = new AccountEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
