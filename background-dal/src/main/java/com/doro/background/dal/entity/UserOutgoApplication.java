package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;


public class UserOutgoApplication {
    private Long applicationId;

    private Long userId;

    private BigDecimal deductAmount;

    private BigDecimal actualAmount;

    private BigDecimal feeAmount;

    private Integer enumWithdrawState;

    private String remark;

    private Date createTime;
    
    public enum EnumWithdrawState {
        SQZ( 0, "待系统审核"),DRSH( 100, "待人审核"),YTJFK( 200, " 已提交付款"),SHCG(300,"成功"),YC( -100, "资金异常"),YCYCL(-200,"异常已处理");

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

    public BigDecimal getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(BigDecimal deductAmount) {
        this.deductAmount = deductAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
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