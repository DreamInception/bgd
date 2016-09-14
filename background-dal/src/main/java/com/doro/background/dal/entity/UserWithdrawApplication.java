package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;


public class UserWithdrawApplication {
    private Long applicationId;

    private Long userId;

    private BigDecimal totalAmount;

    private BigDecimal withdrawAmount;

    private BigDecimal feeAmount;

    private Integer enumWithdrawState;

    private Date releaseTime;

    private String remark;

    private Date createTime;
    //状态 中间变量
    private String state;
    
    
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private UserAuth userAuth = new UserAuth();
    
    
    
    

	public UserAuth getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(UserAuth userAuth) {
		this.userAuth = userAuth;
	}

	public enum EnumWithdrawState {
        SQZ( 0, "申请中"),XTSHTG( 100, "系统审核通过"),SHCLZ( 200, "赎回处理中"),SHCG(300,"赎回成功"),YC( -100, "资金异常");

        private int code;
        private String text;

        EnumWithdrawState(int code, String text) {
            this.code = code;
            this.text = text;
        }

        public static String getDescs(int code) {
        	EnumWithdrawState psyt = getByCode(code);
            if (psyt != null)
                return psyt.text;
            return "";
        }

        public static EnumWithdrawState getByCode(int code) {
            for (EnumWithdrawState type : EnumWithdrawState.values()) {
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Integer getEnumWithdrawState() {
        return enumWithdrawState;
    }

    public void setEnumWithdrawState(Integer enumWithdrawState) {
        this.enumWithdrawState = enumWithdrawState;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
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
}