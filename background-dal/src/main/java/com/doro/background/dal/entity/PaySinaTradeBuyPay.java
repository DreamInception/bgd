package com.doro.background.dal.entity;

import java.math.BigDecimal;
import java.util.Date;


public class PaySinaTradeBuyPay {
    private Long tradeId;

    private String title;

    private String outTradeNo;

    private String payeeIdentityId;

    private String payeeIdentityType;

    private BigDecimal amount;

    private Integer enumSinaTradeState;

    private String opRemark;

    private String remark;

    private Date createTime;
    
    //状态
    private String state;
    
    
    
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public enum EnumSinaTradeState {
        LOADIING( 0, "处理中"), SUCCESS( 100, "成功"),FAIL( -100, "失败");

        private int code;
        private String text;

        EnumSinaTradeState(int code, String text) {
            this.code = code;
            this.text = text;
        }

        public static String getDescs(int code) {
        	EnumSinaTradeState psyt = getByCode(code);
            if (psyt != null)
                return psyt.text;
            return "";
        }

        public static EnumSinaTradeState getByCode(int code) {
            for (EnumSinaTradeState type : EnumSinaTradeState.values()) {
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

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getPayeeIdentityId() {
        return payeeIdentityId;
    }

    public void setPayeeIdentityId(String payeeIdentityId) {
        this.payeeIdentityId = payeeIdentityId == null ? null : payeeIdentityId.trim();
    }

    public String getPayeeIdentityType() {
        return payeeIdentityType;
    }

    public void setPayeeIdentityType(String payeeIdentityType) {
        this.payeeIdentityType = payeeIdentityType == null ? null : payeeIdentityType.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getEnumSinaTradeState() {
        return enumSinaTradeState;
    }

    public void setEnumSinaTradeState(Integer enumSinaTradeState) {
        this.enumSinaTradeState = enumSinaTradeState;
    }

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark == null ? null : opRemark.trim();
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