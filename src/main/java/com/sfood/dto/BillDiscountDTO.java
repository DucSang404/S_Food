package com.sfood.dto;

public class BillDiscountDTO extends DiscountDTO{
    private String code;
    private Long loyaltyPointsRequired;
    private Long maximumAmount;
    private Long minimumInvoiceAmount;

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

    public Long getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Long maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Long getMinimumInvoiceAmount() {
        return minimumInvoiceAmount;
    }

    public void setMinimumInvoiceAmount(Long minimumInvoiceAmount) {
        this.minimumInvoiceAmount = minimumInvoiceAmount;
    }
}
