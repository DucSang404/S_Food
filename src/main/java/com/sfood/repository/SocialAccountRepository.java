package com.sfood.repository;

import com.sfood.entity.account.SocialAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialAccountRepository extends JpaRepository<SocialAccountEntity, Long> {
    boolean existsByGgId(String ggId);
}
