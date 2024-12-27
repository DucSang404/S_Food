package com.sfood.entity.actor;

import com.sfood.entity.account.AccountEntity;
import com.sfood.entity.shipping.AddressEntity;

import javax.persistence.*;

@Entity
@Table(name = "[owner]")
public class OwnerEntity extends UserEntity{
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @OneToOne(mappedBy = "owner")
    private AccountEntity account;

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
