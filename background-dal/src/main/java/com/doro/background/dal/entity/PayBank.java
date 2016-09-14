package com.doro.background.dal.entity;

import java.math.BigDecimal;


public class PayBank {
    private Long autoId;

    private String bankCode;

    private String channelBankCode;

    private String bankName;

    private BigDecimal timesLimit;

    private BigDecimal dayLimit;

    private String tip;

    private String icon;

    private Integer enumExpenseIncomeChannel;

    private Integer sort;

    private Boolean isEnable;
    
    public enum EnumExpenseIncomeChannel {
        SYSTEM( 0, "系统"), SINA( 100, "新浪"),BOOFOO(200,"宝付");

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

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getChannelBankCode() {
        return channelBankCode;
    }

    public void setChannelBankCode(String channelBankCode) {
        this.channelBankCode = channelBankCode == null ? null : channelBankCode.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public BigDecimal getTimesLimit() {
        return timesLimit;
    }

    public void setTimesLimit(BigDecimal timesLimit) {
        this.timesLimit = timesLimit;
    }

    public BigDecimal getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(BigDecimal dayLimit) {
        this.dayLimit = dayLimit;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getEnumExpenseIncomeChannel() {
        return enumExpenseIncomeChannel;
    }

    public void setEnumExpenseIncomeChannel(Integer enumExpenseIncomeChannel) {
        this.enumExpenseIncomeChannel = enumExpenseIncomeChannel;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }
}