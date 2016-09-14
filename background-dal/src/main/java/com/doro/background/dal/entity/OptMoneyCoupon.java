package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OptMoneyCoupon {
	private Long autoId;

	private Long userId;

	private BigDecimal amount;

	private BigDecimal yearRate;

	private BigDecimal dayRate;

	private Integer dayCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	private BigDecimal minAmount;

	private Integer minDays;

	private Integer enumSendgiftState;

	private Long sendAdminid;

	private Long auditAdminid;

	private String remark;

	private Date createTime;

	public Long getAutoId() {
		return autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public Integer getEnumSendgiftState() {
		return enumSendgiftState;
	}

	public void setEnumSendgiftState(Integer enumSendgiftState) {
		this.enumSendgiftState = enumSendgiftState;
	}

	public Long getSendAdminid() {
		return sendAdminid;
	}

	public void setSendAdminid(Long sendAdminid) {
		this.sendAdminid = sendAdminid;
	}

	public Long getAuditAdminid() {
		return auditAdminid;
	}

	public void setAuditAdminid(Long auditAdminid) {
		this.auditAdminid = auditAdminid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 
	 * @author ZiLing
	 *
	 */
	public enum EnumSendgiftState {
		INCOME(0, "录入"), REVIEWING(100, "待审核"), SUCCESS(200, "审核通过");

		private int code;
		private String text;

		EnumSendgiftState(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getText(int code) {
			EnumSendgiftState ets = getByCode(code);
			if (ets != null)
				return ets.text;
			return "";
		}

		public static EnumSendgiftState getByCode(int code) {
			for (EnumSendgiftState state : EnumSendgiftState.values()) {
				if (code == state.code)
					return state;
			}
			return null;
		}

		public int getCode() {
			return code;
		}

		public String getText() {
			return text;
		}
	}
}