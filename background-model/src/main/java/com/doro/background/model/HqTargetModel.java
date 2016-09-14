package com.doro.background.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HqTargetModel {
	private Long targetId;
	private String sTargetId;
	private String targetName;

	private BigDecimal targetAmount;

	private BigDecimal targetBidAmount;

	private BigDecimal targetYearRate;

	private BigDecimal targetDayRate;

	private Integer enumTargetState;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date onsaleTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

	private Integer enumRecordState;
	private Long actAutoId;
	private String actName;
	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getsTargetId() {
		return sTargetId;
	}

	public void setsTargetId(String sTargetId) {
		this.sTargetId = sTargetId;
	}

	public Long getActAutoId() {
		return actAutoId;
	}

	public void setActAutoId(Long actAutoId) {
		this.actAutoId = actAutoId;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName == null ? null : targetName.trim();
	}

	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}

	public BigDecimal getTargetBidAmount() {
		return targetBidAmount;
	}

	public void setTargetBidAmount(BigDecimal targetBidAmount) {
		this.targetBidAmount = targetBidAmount;
	}

	public BigDecimal getTargetYearRate() {
		return targetYearRate;
	}

	public void setTargetYearRate(BigDecimal targetYearRate) {
		this.targetYearRate = targetYearRate;
	}

	public BigDecimal getTargetDayRate() {
		return targetDayRate;
	}

	public void setTargetDayRate(BigDecimal targetDayRate) {
		this.targetDayRate = targetDayRate;
	}

	public Integer getEnumTargetState() {
		return enumTargetState;
	}

	public void setEnumTargetState(Integer enumTargetState) {
		this.enumTargetState = enumTargetState;
	}

	public Date getOnsaleTime() {
		return onsaleTime;
	}

	public void setOnsaleTime(Date onsaleTime) {
		this.onsaleTime = onsaleTime;
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

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	/**
	 * 标的的状态
	 * 
	 * @author ZiLing
	 *
	 */
	public enum EnumTargetState {
		EDIT(0, "录入"), WAITSHELVES(100, "待上架"), ONSHELVES(200, "上架"), FULL(300, "满标");

		private int code;
		private String text;

		EnumTargetState(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getText(int code) {
			EnumTargetState ets = getByCode(code);
			if (ets != null)
				return ets.text;
			return "";
		}

		public static EnumTargetState getByCode(int code) {
			for (EnumTargetState state : EnumTargetState.values()) {
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
	 * 标的记录状态
	 * 
	 * @author ZiLing
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
			EnumRecordState ers = getByCode(code);
			if (ers != null)
				return ers.text;
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