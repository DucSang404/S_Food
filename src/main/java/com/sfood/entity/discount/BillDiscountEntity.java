package com.sfood.entity.discount;

import com.sfood.entity.order.OrderEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[bill_discount]")
public class BillDiscountEntity extends DiscountEntity{
    @Column(name = "code")
    private String code;

    @Column(name = "loyalty_points_required")
    private Long loyaltyPointsRequired;
    @Column(name = "minimum_invoice_amount")
    private Long minimumInvoiceAmount;

    @OneToMany(mappedBy = "billDiscount")
    private List<OrderEntity> lstOrder = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getLoyaltyPointsRequired() {
        return loyaltyPointsRequired;
    }

    public void setLoyaltyPointsRequired(Long loyaltyPointsRequired) {
        this.loyaltyPointsRequired = loyaltyPointsRequired;
    }

    public Long getMinimumInvoiceAmount() {
        return minimumInvoiceAmount;
    }

    public void setMinimumInvoiceAmount(Long minimumInvoiceAmount) {
        this.minimumInvoiceAmount = minimumInvoiceAmount;
    }

    public List<OrderEntity> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<OrderEntity> lstOrder) {
        this.lstOrder = lstOrder;
    }
}
