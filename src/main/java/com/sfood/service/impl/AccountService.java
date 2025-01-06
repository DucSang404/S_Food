package com.sfood.service.impl;

import com.sfood.dto.AccountDTO;
import com.sfood.dto.CustomerDTO;
import com.sfood.entity.account.AccountEntity;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.enums.EnumAccountStatus;
import com.sfood.mapper.impl.AccountMapper;
import com.sfood.mapper.impl.CustomerMapper;
import com.sfood.repository.AccountRepository;
import com.sfood.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CustomerMapper customerMapper;

    public boolean isUsernameTaken(String username) {
        return accountRepository.existsByUserName(username);
    }

    public boolean isEmailTaken(String email) {
        return customerRepository.existsByEmail(email);
    }

    public boolean isPhoneTaken(String phone) {
        return customerRepository.existsByPhone(phone);
    }

    public void registerAccount(AccountDTO accountDTO, CustomerDTO customerDTO) {
        accountDTO.setStatus(EnumAccountStatus.ACTIVE);
        AccountEntity accountEntity = accountMapper.toEntity(accountDTO);
        CustomerEntity customerEntity = customerMapper.toEntity(customerDTO);

        String encodePassword = passwordEncoder.encode(accountEntity.getPassword());
        accountEntity.setPassword(encodePassword);
        accountEntity.setCustomer(customerEntity);
        accountRepository.save(accountEntity);
    }

    public CustomerDTO findCustomerByUserName(String username) {
        AccountEntity accountEntity = accountRepository.findByUserName(username);
        CustomerEntity customerEntity = accountEntity.getCustomer();
        return customerMapper.toDTO(customerEntity);
    }
}
