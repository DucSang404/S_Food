package com.sfood.dto;

public class OwnerDTO extends UserDTO{
    private AddressDTO address;

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
