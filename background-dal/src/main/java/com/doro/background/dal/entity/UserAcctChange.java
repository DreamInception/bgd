package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserAcctChange {
    private Long mapAutoId;

    private Long userId;

    private Integer enumAcctType;

    private BigDecimal amount;

    private String remark;

    private Date createTime;

    public Long getMapAutoId() {
        return mapAutoId;
    }

    public void setMapAutoId(Long mapAutoId) {
        this.mapAutoId = mapAutoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getEnumAcctType() {
        return enumAcctType;
    }

    public void setEnumAcctType(Integer enumAcctType) {
        this.enumAcctType = enumAcctType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
    
    public enum EnumAcctType {
		KYYE(0, "可用余额"), DJYE(100, "冻结余额");

		private int code;
		private String text;

		EnumAcctType(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getText(int code) {
			EnumAcctType ets = getByCode(code);
			if (ets != null)
				return ets.text;
			return "";
		}

		public static EnumAcctType getByCode(int code) {
			for (EnumAcctType state : EnumAcctType.values()) {
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