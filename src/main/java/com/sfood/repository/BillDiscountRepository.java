package com.sfood.repository;

import com.sfood.entity.discount.BillDiscountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDiscountRepository extends JpaRepository<BillDiscountEntity, Long> {
    @Query("SELECT b FROM BillDiscountEntity b WHERE CURRENT_DATE BETWEEN b.startDate AND b.endDate")
    List<BillDiscountEntity> findAllValidBillDiscount();
}
