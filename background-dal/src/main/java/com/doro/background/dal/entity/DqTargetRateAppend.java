package com.doro.background.dal.entity;

import java.math.BigDecimal;

public class DqTargetRateAppend {
    private Long targetId;

    private String appendLable;

    private BigDecimal appendYearDate;

    private BigDecimal appendDayRate;

    private Integer appendDayCount;

    private Long actAutoId;

    private String actName;

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getAppendLable() {
        return appendLable;
    }

    public void setAppendLable(String appendLable) {
        this.appendLable = appendLable == null ? null : appendLable.trim();
    }

    public BigDecimal getAppendYearDate() {
        return appendYearDate;
    }

    public void setAppendYearDate(BigDecimal appendYearDate) {
        this.appendYearDate = appendYearDate;
    }

    public BigDecimal getAppendDayRate() {
        return appendDayRate;
    }

    public void setAppendDayRate(BigDecimal appendDayRate) {
        this.appendDayRate = appendDayRate;
    }

    public Integer getAppendDayCount() {
        return appendDayCount;
    }

    public void setAppendDayCount(Integer appendDayCount) {
        this.appendDayCount = appendDayCount;
    }

    public Long getActAutoId() {
        return actAutoId;
    }

    public void setActAutoId(Long actAutoId) {
        this.actAutoId = actAutoId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName == null ? null : actName.trim();
    }
}