package com.doro.background.sina.entity;

import java.math.BigDecimal;

public class CreateHostingDeposit {
	private String outTradeNo;
	private String summary;
	private String identityId;
	private String identityType;
	private String accountType;
	private BigDecimal amount;
	private String userFee;
	private String payerIp;
	private String payMethod;
	private String extendParam;
	private String returnUrl;
	private String notifyUrl;
	
	
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public String getIdentityType() {
		return identityType==null?"UID":identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getAccountType() {
		return accountType==null?"SAVING_POT":accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getUserFee() {
		return userFee;
	}
	public void setUserFee(String userFee) {
		this.userFee = userFee;
	}
	public String getPayerIp() {
		return payerIp;
	}
	public void setPayerIp(String payerIp) {
		this.payerIp = payerIp;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
	
}
