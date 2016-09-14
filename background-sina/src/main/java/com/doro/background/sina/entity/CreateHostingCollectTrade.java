package com.doro.background.sina.entity;

public class CreateHostingCollectTrade {
	private String outTradeNo;
	private String outTradeCode;
	private String summary;
	private String tradeCloseTime;
	private String canRepayOnFailed;
	private String extendParam;
	private String goodsId;
	private String payerId;
	private String payerIdentityType;
	private String payerIp;
	private String payMethod;
	private String collectTradeType;
	private String returnUrl;
	private String notifyUrl;
	private String amount;
	private String bankCode;
	
	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTradeCloseTime() {
		return tradeCloseTime==null?"20m":tradeCloseTime;
	}
	public void setTradeCloseTime(String tradeCloseTime) {
		this.tradeCloseTime = tradeCloseTime;
	}
	public String getCanRepayOnFailed() {
		return canRepayOnFailed==null?"N":"N";
	}
	public void setCanRepayOnFailed(String canRepayOnFailed) {
		this.canRepayOnFailed = canRepayOnFailed;
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
	public String getPayerId() {
		return payerId;
	}
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}
	public String getPayerIdentityType() {
		return payerIdentityType==null?"UID":payerIdentityType;
	}
	public void setPayerIdentityType(String payerIdentityType) {
		this.payerIdentityType = payerIdentityType;
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
	public String getCollectTradeType() {
		return collectTradeType;
	}
	public void setCollectTradeType(String collectTradeType) {
		this.collectTradeType = collectTradeType;
	}
	
}
