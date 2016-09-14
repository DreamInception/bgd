package com.doro.background.sina.entity;

public class QueryBalance {
	private String identityId;
	private String identityType;
	private String accountType;
	private String extendParam;
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
	public String getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
}
