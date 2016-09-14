package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserHqRedeemApplication {
	private Long applicationId;

	private Long userId;

	private BigDecimal amount;

	private Integer enumRedeemState;

	private String remark;

	private Date createTime;

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
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

	public Integer getEnumRedeemState() {
		return enumRedeemState;
	}

	public void setEnumRedeemState(Integer enumRedeemState) {
		this.enumRedeemState = enumRedeemState;
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

	public enum EnumRedeemState {
		SQZ(0, "申请中"), XTSHTG(100, "系统审核通过"), SHCG(200, "赎回成功"), YC(-100, "资金异常");

		private int code;
		private String text;

		EnumRedeemState(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getDescs(int code) {
			EnumRedeemState psyt = getByCode(code);
			if (psyt != null)
				return psyt.text;
			return "";
		}

		public static EnumRedeemState getByCode(int code) {
			for (EnumRedeemState type : EnumRedeemState.values()) {
				if (code == type.code)
					return type;
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