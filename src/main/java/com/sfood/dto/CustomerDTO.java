package com.sfood.dto;

public class CustomerDTO extends UserDTO{
    private Long loyaltyPoints;

    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
