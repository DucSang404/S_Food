package com.sfood.repository;

import com.sfood.entity.account.AccountEntity;
import com.sfood.enums.EnumAccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findOneByUserNameAndStatus(String username, EnumAccountStatus status);
    boolean existsByUserName(String username);
}
