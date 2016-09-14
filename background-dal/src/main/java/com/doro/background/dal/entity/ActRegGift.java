package com.doro.background.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActRegGift {
    private Long actAutoId;

    private String actName;

    private Date beginDate;

    private Date endDate;

    private Boolean isOnsale;

    private List<ActMoneyCouponItem> actMoneyCouponItems = new ArrayList<>();
    
    private List<ActRateCouponItem> actRateCouponItems = new ArrayList<>();
    
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

	public List<ActMoneyCouponItem> getActMoneyCouponItems() {
		return actMoneyCouponItems;
	}

	public void setActMoneyCouponItems(List<ActMoneyCouponItem> actMoneyCouponItems) {
		this.actMoneyCouponItems = actMoneyCouponItems;
	}

	public List<ActRateCouponItem> getActRateCouponItems() {
		return actRateCouponItems;
	}

	public void setActRateCouponItems(List<ActRateCouponItem> actRateCouponItems) {
		this.actRateCouponItems = actRateCouponItems;
	}
}