package com.sfood.service.impl;

import com.nimbusds.jose.JOSEException;
import com.sfood.dto.MyUser;
import com.sfood.entity.account.AccountEntity;
import com.sfood.entity.account.SocialAccountEntity;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.enums.EnumAccountStatus;
import com.sfood.repository.AccountRepository;
import com.sfood.repository.CustomerRepository;
import com.sfood.repository.SocialAccountRepository;
import com.sfood.util.JwtUtils;
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
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SocialAccountRepository socialAccountRepository;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findOneByUserNameAndStatus(username, EnumAccountStatus.ACTIVE);
        if(accountEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String role = determineRole(accountEntity);
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));

        return new MyUser(accountEntity.getUsername(), accountEntity.getPassword(),
                true, true, true, true, authorities);
    }

    public String generateToken(String username) throws JOSEException {
        AccountEntity accountEntity = accountRepository.findByUserName(username);
        CustomerEntity customerEntity = customerRepository.findById(accountEntity.getCustomer().getId());
        return jwtUtils.generateToken(username, customerEntity.getId());
    }

    public String generateTokenSocial(String socialId) throws JOSEException {
        SocialAccountEntity socialAccountEntity= socialAccountRepository.findByGgId(socialId);
        if(socialAccountEntity == null) {
            socialAccountEntity = socialAccountRepository.findByFbId(socialId);
        }
        CustomerEntity customerEntity = customerRepository.findById(socialAccountEntity.getCustomer().getId());
        return jwtUtils.generateToken(socialId, customerEntity.getId());
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
