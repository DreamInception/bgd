package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HqDebt {
	private Long debtId;

	private Integer enumDebtType;

	private String debtName;

	private BigDecimal debtAmount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date repayDate;

	private Integer debtLevel;

	private String debtFrom;

	private Integer enumDebtState;

	private Date createTime;

	private Integer enumRecordState;

	public Long getDebtId() {
		return debtId;
	}

	public void setDebtId(Long debtId) {
		this.debtId = debtId;
	}

	public Integer getEnumDebtType() {
		return enumDebtType;
	}

	public void setEnumDebtType(Integer enumDebtType) {
		this.enumDebtType = enumDebtType;
	}

	public String getDebtName() {
		return debtName;
	}

	public void setDebtName(String debtName) {
		this.debtName = debtName == null ? null : debtName.trim();
	}

	public BigDecimal getDebtAmount() {
		return debtAmount;
	}

	public void setDebtAmount(BigDecimal debtAmount) {
		this.debtAmount = debtAmount;
	}

	public Date getRepayDate() {
		return repayDate;
	}

	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}

	public Integer getDebtLevel() {
		return debtLevel;
	}

	public void setDebtLevel(Integer debtLevel) {
		this.debtLevel = debtLevel;
	}

	public String getDebtFrom() {
		return debtFrom;
	}

	public void setDebtFrom(String debtFrom) {
		this.debtFrom = debtFrom == null ? null : debtFrom.trim();
	}

	public Integer getEnumDebtState() {
		return enumDebtState;
	}

	public void setEnumDebtState(Integer enumDebtState) {
		this.enumDebtState = enumDebtState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getEnumRecordState() {
		return enumRecordState;
	}

	public void setEnumRecordState(Integer enumRecordState) {
		this.enumRecordState = enumRecordState;
	}

	/**
	 * 
	 * 债权类型
	 *
	 */
	public enum EnumDebtType {
		INCOME(0, "收益权转让");

		private int code;
		private String text;

		EnumDebtType(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getText(int code) {
			EnumDebtType ets = getByCode(code);
			if (ets != null)
				return ets.text;
			return "";
		}

		public static EnumDebtType getByCode(int code) {
			for (EnumDebtType state : EnumDebtType.values()) {
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

	/**
	 * 
	 * 债权状态
	 *
	 */
	public enum EnumDebtState {
		ENTERING(0, "录入"), PENDINGAPPROVAL(100, "待审核"), ONSHELVES(200, "上架"), PAYOVER(300, "已还款");

		private int code;
		private String text;

		EnumDebtState(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getText(int code) {
			EnumDebtState ets = getByCode(code);
			if (ets != null)
				return ets.text;
			return "";
		}

		public static EnumDebtState getByCode(int code) {
			for (EnumDebtState state : EnumDebtState.values()) {
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
	
	/**
	 * 
	 * 债权记录的状态
	 *
	 */
	public enum EnumRecordState {
		DELETE(-100, "删除"), NORMAL(100, "正常");

		private int code;
		private String text;

		EnumRecordState(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getText(int code) {
			EnumRecordState ets = getByCode(code);
			if (ets != null)
				return ets.text;
			return "";
		}

		public static EnumRecordState getByCode(int code) {
			for (EnumRecordState state : EnumRecordState.values()) {
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