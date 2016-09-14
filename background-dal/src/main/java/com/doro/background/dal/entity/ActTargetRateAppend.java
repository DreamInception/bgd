package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ActTargetRateAppend {
	private Long actAutoId;

	private String actName;

	private String appendLable;

	private BigDecimal appendYearRate;

	private BigDecimal appendDayRate;

	private Integer appendDayCount;
	
	private Date beginDate;
	
	private Date endDate;

	private int isOnsale;

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
		this.actName = actName;
	}

	public String getAppendLable() {
		return appendLable;
	}

	public void setAppendLable(String appendLable) {
		this.appendLable = appendLable;
	}

	public BigDecimal getAppendYearRate() {
		return appendYearRate;
	}

	public void setAppendYearRate(BigDecimal appendYearRate) {
		this.appendYearRate = appendYearRate;
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

	public int getIsOnsale() {
		return isOnsale;
	}

	public void setIsOnsale(int isOnsale) {
		this.isOnsale = isOnsale;
	}
}
