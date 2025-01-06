package com.sfood.repository;

import com.sfood.entity.actor.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    CustomerEntity findByAccountId(Long accountId);
    CustomerEntity findById(Long customerId);

}
