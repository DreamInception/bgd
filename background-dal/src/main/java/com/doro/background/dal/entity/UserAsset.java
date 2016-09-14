package com.doro.background.dal.entity;

import java.math.BigDecimal;

public class UserAsset {
    private Long userAssetId;

    private Long userId;

    private Integer enumAsset;

    private BigDecimal assetBalance;

    private BigDecimal assetFrozen;

    public Long getUserAssetId() {
        return userAssetId;
    }

    public void setUserAssetId(Long userAssetId) {
        this.userAssetId = userAssetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getEnumAsset() {
        return enumAsset;
    }

    public void setEnumAsset(Integer enumAsset) {
        this.enumAsset = enumAsset;
    }

    public BigDecimal getAssetBalance() {
        return assetBalance;
    }

    public void setAssetBalance(BigDecimal assetBalance) {
        this.assetBalance = assetBalance;
    }

    public BigDecimal getAssetFrozen() {
        return assetFrozen;
    }

    public void setAssetFrozen(BigDecimal assetFrozen) {
        this.assetFrozen = assetFrozen;
    }
}