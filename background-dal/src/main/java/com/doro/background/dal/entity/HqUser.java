package com.doro.background.dal.entity;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class HqUser{
    private Long hqUserId;

    private Long userId;

    private Long targetId;

    private BigDecimal buyAmount;

    private BigDecimal currentAmount;

    private BigDecimal yearRate;

    
    private BigDecimal dayRate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextAppendDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextPayDate;

    private Boolean isMatch;

    private Date matchTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date buyTime;
    /**
     * ·ÖÒ³²ÎÊý
     * @return
     */
    private Integer pageNum;
    
    private UserLogin user;
    
    private HqTarget hqTarget;

   

	public UserLogin getUser() {
		return user;
	}

	public void setUser(UserLogin user) {
		this.user = user;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Long getHqUserId() {
        return hqUserId;
    }

    public void setHqUserId(Long hqUserId) {
        this.hqUserId = hqUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTartgetId(Long targetId) {
        this.targetId = targetId;
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

    public Date getNextAppendDate() {
        return nextAppendDate;
    }

    public void setNextAppendDate(Date nextAppendDate) {
        this.nextAppendDate = nextAppendDate;
    }

    public Date getNextPayDate() {
        return nextPayDate;
    }

    public void setNextPayDate(Date nextPayDate) {
        this.nextPayDate = nextPayDate;
    }

    public Boolean getIsMatch() {
        return isMatch;
    }

    public void setIsMatch(Boolean isMatch) {
        this.isMatch = isMatch;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

	public HqTarget getHqTarget() {
		return hqTarget;
	}

	public void setHqTarget(HqTarget hqTarget) {
		this.hqTarget = hqTarget;
	}
    
    
}