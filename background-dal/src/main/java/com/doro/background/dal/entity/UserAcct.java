package com.doro.background.dal.entity;

import java.math.BigDecimal;

public class UserAcct {
    private Long userId;

    private BigDecimal acctBalance;

    private BigDecimal acctFrozen;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(BigDecimal acctBalance) {
        this.acctBalance = acctBalance;
    }

    public BigDecimal getAcctFrozen() {
        return acctFrozen;
    }

    public void setAcctFrozen(BigDecimal acctFrozen) {
        this.acctFrozen = acctFrozen;
    }
}