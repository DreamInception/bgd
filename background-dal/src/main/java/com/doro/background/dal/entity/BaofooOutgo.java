package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BaofooOutgo {
    private Long autoId;

    private Long applicationId;

    private String transNo;

    private BigDecimal transMoney;

    private String toAccName;

    private String toAccNo;

    private String toBankName;

    private String toProName;

    private String toCityName;

    private String toAccDept;

    private String transSummary;

    private String remark;

    private Integer enumTradeState;

    private Date createTime;
    
    public enum EnumTradeState {
        LOADING( 0, "处理中"), SUCCESS( 100, "成功"),FAIL(200,"失败");

        private int code;
        private String text;

        EnumTradeState(int code, String text) {
            this.code = code;
            this.text = text;
        }

        public static String getDescs(int code) {
        	EnumTradeState psyt = getByCode(code);
            if (psyt != null)
                return psyt.text;
            return "";
        }

        public static EnumTradeState getByCode(int code) {
            for (EnumTradeState type : EnumTradeState.values()) {
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

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    public BigDecimal getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(BigDecimal transMoney) {
        this.transMoney = transMoney;
    }

    public String getToAccName() {
        return toAccName;
    }

    public void setToAccName(String toAccName) {
        this.toAccName = toAccName == null ? null : toAccName.trim();
    }

    public String getToAccNo() {
        return toAccNo;
    }

    public void setToAccNo(String toAccNo) {
        this.toAccNo = toAccNo == null ? null : toAccNo.trim();
    }

    public String getToBankName() {
        return toBankName;
    }

    public void setToBankName(String toBankName) {
        this.toBankName = toBankName == null ? null : toBankName.trim();
    }

    public String getToProName() {
        return toProName;
    }

    public void setToProName(String toProName) {
        this.toProName = toProName == null ? null : toProName.trim();
    }

    public String getToCityName() {
        return toCityName;
    }

    public void setToCityName(String toCityName) {
        this.toCityName = toCityName == null ? null : toCityName.trim();
    }

    public String getToAccDept() {
        return toAccDept;
    }

    public void setToAccDept(String toAccDept) {
        this.toAccDept = toAccDept == null ? null : toAccDept.trim();
    }

    public String getTransSummary() {
        return transSummary;
    }

    public void setTransSummary(String transSummary) {
        this.transSummary = transSummary == null ? null : transSummary.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getEnumTradeState() {
        return enumTradeState;
    }

    public void setEnumTradeState(Integer enumTradeState) {
        this.enumTradeState = enumTradeState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}