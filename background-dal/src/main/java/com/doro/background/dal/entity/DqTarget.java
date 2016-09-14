package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DqTarget {
    private Long targetId;

    private String targetName;

    private String targetIcon;

    private BigDecimal targetAmount;

    private BigDecimal buyAmount;

    private BigDecimal unitAmount;

    private BigDecimal minAmount;

    private Date beginDate;

    private Date endDate;

    private BigDecimal yearRate;

    private BigDecimal dayRate;

    private Date onsaleTime;

    private Date fullsaleTime;

    private Integer enumDqtargetState;

    private Date createTime;

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName == null ? null : targetName.trim();
    }

    public String getTargetIcon() {
        return targetIcon;
    }

    public void setTargetIcon(String targetIcon) {
        this.targetIcon = targetIcon == null ? null : targetIcon.trim();
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Date getOnsaleTime() {
        return onsaleTime;
    }

    public void setOnsaleTime(Date onsaleTime) {
        this.onsaleTime = onsaleTime;
    }

    public Date getFullsaleTime() {
        return fullsaleTime;
    }

    public void setFullsaleTime(Date fullsaleTime) {
        this.fullsaleTime = fullsaleTime;
    }

    public Integer getEnumDqtargetState() {
        return enumDqtargetState;
    }

    public void setEnumDqtargetState(Integer enumDqtargetState) {
        this.enumDqtargetState = enumDqtargetState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}