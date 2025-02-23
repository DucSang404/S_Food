package com.sfood.entity.shipping;

import com.sfood.entity.actor.OwnerEntity;

import javax.persistence.*;

@Entity
@Table(name = "[address]")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @OneToOne(mappedBy = "address")
    private OwnerEntity owner;

    @OneToOne(mappedBy = "address")
    private OrderInfoEntity orderInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }



    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public OrderInfoEntity getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfoEntity orderInfo) {
        this.orderInfo = orderInfo;
    }
}
