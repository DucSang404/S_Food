package com.sfood.entity.order;

import com.sfood.entity.discount.BillDiscountEntity;
import com.sfood.entity.shipping.OrderInfoEntity;
import com.sfood.entity.shipping.OrderShippingEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[order]")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_method")
    private String paymentMethod;

    @OneToMany(mappedBy = "order")
    private List<OrderDetailsEntity> lstOrderDetails = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "order_info_id", referencedColumnName = "id")
    private OrderInfoEntity orderInfo;

    @OneToOne(mappedBy = "order")
    private OrderShippingEntity orderShipping;

    @OneToMany(mappedBy = "order")
    private List<OrderStatus> lstOrderStatus = new ArrayList<>();

    @OneToOne(mappedBy = "order")
    private ReturnOrderEntity returnOrder;

    @ManyToOne
    @JoinColumn(name = "bill_discount_id", referencedColumnName = "id")
    private BillDiscountEntity billDiscount;

    public BillDiscountEntity getBillDiscount() {
        return billDiscount;
    }

    public void setBillDiscount(BillDiscountEntity billDiscount) {
        this.billDiscount = billDiscount;
    }

    public ReturnOrderEntity getReturnOrder() {
        return returnOrder;
    }

    public void setReturnOrder(ReturnOrderEntity returnOrder) {
        this.returnOrder = returnOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<OrderDetailsEntity> getLstOrderDetails() {
        return lstOrderDetails;
    }

    public void setLstOrderDetails(List<OrderDetailsEntity> lstOrderDetails) {
        this.lstOrderDetails = lstOrderDetails;
    }

    public OrderInfoEntity getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfoEntity orderInfo) {
        this.orderInfo = orderInfo;
    }

    public OrderShippingEntity getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(OrderShippingEntity orderShipping) {
        this.orderShipping = orderShipping;
    }

    public List<OrderStatus> getLstOrderStatus() {
        return lstOrderStatus;
    }

    public void setLstOrderStatus(List<OrderStatus> lstOrderStatus) {
        this.lstOrderStatus = lstOrderStatus;
    }
}
