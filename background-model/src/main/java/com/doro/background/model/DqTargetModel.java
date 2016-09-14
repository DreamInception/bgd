package com.doro.background.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DqTargetModel {
	
	/**
	 * 添加
	 */
	private String targetName;

    private String targetIcon;

    private BigDecimal targetAmount;

    private BigDecimal buyAmount;

    private BigDecimal unitAmount;

    private BigDecimal minAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private BigDecimal yearRate;

    private BigDecimal dayRate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date onsaleTime;

    private Date fullsaleTime;

    private Integer enumDqtargetState;

    private Date createTime;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startCreateTime;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endCreateTime;
    
    private String sellerName;
    private String dqContent;
    private long actAutoId;
    private Long targetId;
    
    private String sTargetId;
    private String picRemark;
    private String actName;
    public String getPicRemark() {
		return picRemark;
	}

	public void setPicRemark(String picRemark) {
		this.picRemark = picRemark;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getDqContent() {
		return dqContent;
	}

	public void setDqContent(String dqContent) {
		this.dqContent = dqContent;
	}
	
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

	public Date getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public long getActAutoId() {
		return actAutoId;
	}

	public void setActAutoId(long actAutoId) {
		this.actAutoId = actAutoId;
	}

	public String getsTargetId() {
		return sTargetId;
	}

	public void setsTargetId(String sTargetId) {
		this.sTargetId = sTargetId;
	}
}