package com.sfood.dto;


import java.util.List;

public class OrderDTO {
    private Long id;
    private List<OrderStatusDTO> lstStatus;
    private List<OrderDetailsDTO> lstOrderDetails;
    private String paymentMethod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderStatusDTO> getLstStatus() {
        return lstStatus;
    }

    public void setLstStatus(List<OrderStatusDTO> lstStatus) {
        this.lstStatus = lstStatus;
    }

    public List<OrderDetailsDTO> getLstOrderDetails() {
        return lstOrderDetails;
    }

    public void setLstOrderDetails(List<OrderDetailsDTO> lstOrderDetails) {
        this.lstOrderDetails = lstOrderDetails;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
