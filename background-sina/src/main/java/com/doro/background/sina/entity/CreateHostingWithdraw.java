package com.doro.background.sina.entity;

public class CreateHostingWithdraw {
	
	private String outTradeNo;
	private String summary;
	private String identityId;
	private String identityType;
	private String accountType;
	private String amount;
	private String userFee;
	private String cardId;
	private String withdrawMode;
	private String paytoType;
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
		return identityType == null?"UID":identityType;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUserFee() {
		return userFee;
	}
	public void setUserFee(String userFee) {
		this.userFee = userFee;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getWithdrawMode() {
		return withdrawMode==null?"CASHDESK":withdrawMode;
	}
	public void setWithdrawMode(String withdrawMode) {
		this.withdrawMode = withdrawMode;
	}
	public String getPaytoType() {
		return paytoType;
	}
	public void setPaytoType(String paytoType) {
		this.paytoType = paytoType;
	}
	public String getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
	
}
