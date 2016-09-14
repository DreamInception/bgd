package com.doro.background.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ActRegGiftModel {
    private Long actAutoId;

    private String actName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Boolean isOnsale;

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

    public Boolean getIsOnsale() {
        return isOnsale;
    }

    public void setIsOnsale(Boolean isOnsale) {
        this.isOnsale = isOnsale;
    }
}