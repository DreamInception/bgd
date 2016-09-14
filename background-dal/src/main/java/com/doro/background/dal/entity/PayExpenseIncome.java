package com.doro.background.dal.entity;


import java.math.BigDecimal;
import java.util.Date;

public class PayExpenseIncome {
    private Long expenseIncomeId;

    private Long userId;

    private BigDecimal amount;

    private BigDecimal fee;

    private Integer enumExpenseIncomeType;

    private Integer enumExpenseIncomeChannel;

    private String remark;

    private Date createTime;
    
    public enum EnumExpenseIncomeChannel {
        SYSTEM( 0, "系统"), SINA( 100, "新浪");

        private int code;
        private String text;

        EnumExpenseIncomeChannel(int code, String text) {
            this.code = code;
            this.text = text;
        }

        public static String getDescs(int code) {
        	EnumExpenseIncomeChannel psyt = getByCode(code);
            if (psyt != null)
                return psyt.text;
            return "";
        }

        public static EnumExpenseIncomeChannel getByCode(int code) {
            for (EnumExpenseIncomeChannel type : EnumExpenseIncomeChannel.values()) {
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

    
    public enum EnumExpenseIncomeType {
        RECHARGE( 0, "充值"), WITHDRAW( 100, "提现"),INVEST( 200, "投资"),REDEEM( 300, "赎回");

        private int code;
        private String text;

        EnumExpenseIncomeType(int code, String text) {
            this.code = code;
            this.text = text;
        }

        public static String getDescs(int code) {
        	EnumExpenseIncomeType psyt = getByCode(code);
            if (psyt != null)
                return psyt.text;
            return "";
        }

        public static EnumExpenseIncomeType getByCode(int code) {
            for (EnumExpenseIncomeType type : EnumExpenseIncomeType.values()) {
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

    public Long getExpenseIncomeId() {
        return expenseIncomeId;
    }

    public void setExpenseIncomeId(Long expenseIncomeId) {
        this.expenseIncomeId = expenseIncomeId;
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getEnumExpenseIncomeType() {
        return enumExpenseIncomeType;
    }

    public void setEnumExpenseIncomeType(Integer enumExpenseIncomeType) {
        this.enumExpenseIncomeType = enumExpenseIncomeType;
    }

    public Integer getEnumExpenseIncomeChannel() {
        return enumExpenseIncomeChannel;
    }

    public void setEnumExpenseIncomeChannel(Integer enumExpenseIncomeChannel) {
        this.enumExpenseIncomeChannel = enumExpenseIncomeChannel;
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