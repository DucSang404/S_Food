package com.sfood.dto;

import com.sfood.enums.EnumAccountStatus;

public class SocialAccountDTO {
    private Long id;
    private String fbID;
    private String ggID;
    private EnumAccountStatus status;

    public SocialAccountDTO(Long id, String fbID, String ggID, EnumAccountStatus status) {
        this.id = id;
        this.fbID = fbID;
        this.ggID = ggID;
        this.status = status;
    }

    public SocialAccountDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFbID() {
        return fbID;
    }

    public void setFbID(String fbID) {
        this.fbID = fbID;
    }

    public String getGgID() {
        return ggID;
    }

    public void setGgID(String ggID) {
        this.ggID = ggID;
    }

    public EnumAccountStatus getStatus() {
        return status;
    }

    public void setStatus(EnumAccountStatus status) {
        this.status = status;
    }
}
