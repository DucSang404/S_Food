package com.sfood.entity.actor;

import com.sfood.entity.account.AccountEntity;
import com.sfood.entity.account.SocialAccountEntity;
import com.sfood.entity.cart.CartEntity;
import com.sfood.entity.shipping.OrderInfoEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[customer]")
public class CustomerEntity extends UserEntity{
    @Column(name = "loyalty_point")
    private Long loyaltyPoint;

    @OneToOne(mappedBy = "customer")
    private SocialAccountEntity socialAccount;

    @OneToOne(mappedBy = "customer")
    private AccountEntity account;

    @OneToMany(mappedBy = "customer")
    private List<OrderInfoEntity> orderInfo = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private CartEntity cart;

    public Long getLoyaltyPoint() {
        return loyaltyPoint;
    }

    public void setLoyaltyPoint(Long loyaltyPoint) {
        this.loyaltyPoint = loyaltyPoint;
    }

    public SocialAccountEntity getSocialAccount() {
        return socialAccount;
    }

    public void setSocialAccount(SocialAccountEntity socialAccount) {
        this.socialAccount = socialAccount;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public List<OrderInfoEntity> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(List<OrderInfoEntity> orderInfo) {
        this.orderInfo = orderInfo;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }
}
