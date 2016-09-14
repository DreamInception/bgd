package com.doro.background.sina.entity;

import com.doro.background.sina.tools.CommonUtils;

public class BindingBankCard {
	private String requestNo;
	private String identityId;
	private String identityType;
	private String bankCode;
	private String bankAccountNo;
	private String accountName;
	private String cardType;
	private String cardAttribute;
	private String certType;
	private String certNo;
	private String phoneNo;
	private String validityPeriod;
	private String verificationValue;
	private String province;
	private String city;
	private String bankBranch;
	private String verifyMode;
	private String extendParam;
	public String getRequestNo() {
		return requestNo==null?CommonUtils.getRequestNo():requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
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
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getCardType() {
		return cardType==null?"DEBIT":cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardAttribute() {
		return cardAttribute==null?"C":cardAttribute;
	}
	public void setCardAttribute(String cardAttribute) {
		this.cardAttribute = cardAttribute;
	}
	public String getCertType() {
		return certType==null?"IC":certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(String validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	public String getVerificationValue() {
		return verificationValue;
	}
	public void setVerificationValue(String verificationValue) {
		this.verificationValue = verificationValue;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getVerifyMode() {
		return verifyMode==null?"SIGN":verifyMode;
	}
	public void setVerifyMode(String verifyMode) {
		this.verifyMode = verifyMode;
	}
	public String getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
	public static void main(String[] args) {
		BindingBankCard d = new BindingBankCard();
		System.out.println(d.getRequestNo());
	}
	
}
