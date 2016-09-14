package com.doro.background.sina.entity;

public class CreateSingleHostingPayTrade {
	private String outTradeNo;
	private String outTradeCode;
	private String payeeIdentityId;
	private String payeeIdentityType;
	
	private String accountType;
	private String amount;
	private String splitList;
	private String summary;
	private String extendParam;
	private String goodsId;
	private String returnUrl;
	private String notifyUrl;
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getOutTradeCode() {
		return outTradeCode;
	}
	public void setOutTradeCode(String outTradeCode) {
		this.outTradeCode = outTradeCode;
	}
	public String getPayeeIdentityId() {
		return payeeIdentityId;
	}
	public void setPayeeIdentityId(String payeeIdentityId) {
		this.payeeIdentityId = payeeIdentityId;
	}
	public String getPayeeIdentityType() {
		return payeeIdentityType==null?"UID":payeeIdentityType;
	}
	public void setPayeeIdentityType(String payeeIdentityType) {
		this.payeeIdentityType = payeeIdentityType;
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
	public String getSplitList() {
		return splitList;
	}
	public void setSplitList(String splitList) {
		this.splitList = splitList;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
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
	
	
}
