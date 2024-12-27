package com.sfood.service.impl;

import com.sfood.dto.MyUser;
import com.sfood.entity.account.AccountEntity;
import com.sfood.enums.EnumAccountStatus;
import com.sfood.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findOneByUserNameAndStatus(username, EnumAccountStatus.ACTIVE);
        if(accountEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String role = determineRole(accountEntity);
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));

        MyUser myUser = new MyUser(accountEntity.getUsername(), accountEntity.getPassword(),
                true, true, true, true, authorities);

        return myUser;
    }

    public String determineRole(AccountEntity account) {
        if(account.getCustomer() != null) {
            return "CUSTOMER";
        }
        else if(account.getOwner() != null) {
            return "OWNER";
        }
        throw new IllegalArgumentException("Invalid account type");
    }
}
