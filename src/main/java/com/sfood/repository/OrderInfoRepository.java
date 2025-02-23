package com.sfood.repository;

import com.sfood.entity.shipping.OrderInfoEntity;
import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfoEntity, Long> {
    List<OrderInfoEntity> findAllByCustomerId(Long customerId);
    Optional<OrderInfoEntity> findById(Long orderId);

}
