package com.doro.background.model;

import java.math.BigDecimal;

public class ActRateCouponItemModel {
    private Long autoId;

    private Integer enumActType;

    private Long actId;

    private BigDecimal yearRate;

    private BigDecimal dayRate;

    private Integer dayCount;

    private Integer validDayCount;

    private BigDecimal minAmount;

    private Integer minDays;

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public Integer getEnumActType() {
        return enumActType;
    }

    public void setEnumActType(Integer enumActType) {
        this.enumActType = enumActType;
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

    public BigDecimal getDayRate() {
        return dayRate;
    }

    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Integer getValidDayCount() {
        return validDayCount;
    }

    public void setValidDayCount(Integer validDayCount) {
        this.validDayCount = validDayCount;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMinDays() {
        return minDays;
    }

    public void setMinDays(Integer minDays) {
        this.minDays = minDays;
    }
}