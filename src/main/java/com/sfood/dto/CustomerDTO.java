package com.sfood.dto;

import java.time.LocalDate;

public class CustomerDTO extends UserDTO{
    private Long loyaltyPoints;

    public CustomerDTO(Long id, String name, String email, String phone, LocalDate dateOfBirth, String avatar) {
        super(id, name, email, phone, dateOfBirth, avatar);
    }

    public CustomerDTO() {

    }
    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
