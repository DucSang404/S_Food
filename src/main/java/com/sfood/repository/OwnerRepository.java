package com.sfood.repository;

import com.sfood.entity.actor.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long>{
    OwnerEntity findByAccountId(Long accountId);
}
