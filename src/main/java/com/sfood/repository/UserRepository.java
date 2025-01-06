package com.sfood.repository;

import com.sfood.entity.account.AccountEntity;
import com.sfood.entity.actor.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
