package com.doro.background.dal.entity;


public class UserSina {
    private Long userId;

    private String userSinaId;

    private Boolean isRealName;

    private Boolean isBindingVerify;

    private Boolean isBindingBankCard;

    private Boolean isPayPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserSinaId() {
        return userSinaId;
    }

    public void setUserSinaId(String userSinaId) {
        this.userSinaId = userSinaId == null ? null : userSinaId.trim();
    }

    public Boolean getIsRealName() {
        return isRealName;
    }

    public void setIsRealName(Boolean isRealName) {
        this.isRealName = isRealName;
    }

    public Boolean getIsBindingVerify() {
        return isBindingVerify;
    }

    public void setIsBindingVerify(Boolean isBindingVerify) {
        this.isBindingVerify = isBindingVerify;
    }

    public Boolean getIsBindingBankCard() {
        return isBindingBankCard;
    }

    public void setIsBindingBankCard(Boolean isBindingBankCard) {
        this.isBindingBankCard = isBindingBankCard;
    }

    public Boolean getIsPayPassword() {
        return isPayPassword;
    }

    public void setIsPayPassword(Boolean isPayPassword) {
        this.isPayPassword = isPayPassword;
    }
}