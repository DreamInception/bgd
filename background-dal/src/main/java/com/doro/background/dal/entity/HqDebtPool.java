package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HqDebtPool {
    private Long poolAutoId;

    private Integer enumDebtType;

    private Long debtId;

    private BigDecimal buyAmount;

    private BigDecimal currentAmount;

    private Integer debtLevel;

    private Long sellUserId;

    private Date repayDate;

    private Date createTime;

    public Long getPoolAutoId() {
        return poolAutoId;
    }

    public void setPoolAutoId(Long poolAutoId) {
        this.poolAutoId = poolAutoId;
    }

    public Integer getEnumDebtType() {
        return enumDebtType;
    }

    public void setEnumDebtType(Integer enumDebtType) {
        this.enumDebtType = enumDebtType;
    }

    public Long getDebtId() {
        return debtId;
    }

    public void setDebtId(Long debtId) {
        this.debtId = debtId;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Integer getDebtLevel() {
        return debtLevel;
    }

    public void setDebtLevel(Integer debtLevel) {
        this.debtLevel = debtLevel;
    }

    public Long getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(Long sellUserId) {
        this.sellUserId = sellUserId;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}