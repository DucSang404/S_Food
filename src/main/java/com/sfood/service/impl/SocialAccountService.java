package com.sfood.service.impl;

import com.sfood.dto.CustomerDTO;
import com.sfood.dto.SocialAccountDTO;
import com.sfood.entity.account.SocialAccountEntity;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.mapper.impl.CustomerMapper;
import com.sfood.mapper.impl.SocialAccountMapper;
import com.sfood.repository.SocialAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialAccountService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private SocialAccountMapper socialAccountMapper;
    @Autowired
    private SocialAccountRepository socialAccountRepository;
    public void registerSocialAccount(SocialAccountDTO socialAccountDTO, CustomerDTO customerDTO) {
        if(socialAccountRepository.existsByGgId(socialAccountDTO.getGgID())) {
            return;
        }
        SocialAccountEntity socialAccountEntity = socialAccountMapper.toEntity(socialAccountDTO);
        CustomerEntity customerEntity = customerMapper.toEntity(customerDTO);
        socialAccountEntity.setCustomer(customerEntity);
        socialAccountRepository.save(socialAccountEntity);
    }

    public CustomerDTO findCustomerByFbId(String fbId) {
        SocialAccountEntity socialAccountEntity = socialAccountRepository.findByFbId(fbId);
        CustomerEntity customerEntity = socialAccountEntity.getCustomer();
        return customerMapper.toDTO(customerEntity);
    }

    public CustomerDTO findCustomerByGgId(String ggId) {
        SocialAccountEntity socialAccountEntity = socialAccountRepository.findByGgId(ggId);
        CustomerEntity customerEntity = socialAccountEntity.getCustomer();
        return customerMapper.toDTO(customerEntity);
    }


}
