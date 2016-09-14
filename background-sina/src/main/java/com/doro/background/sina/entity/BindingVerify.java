package com.doro.background.sina.entity;

public class BindingVerify {
	private String identityId;
	private String identityType;
	private String verifyType;
	private String verifyEntity;
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
	public String getVerifyType() {
		return verifyType == null?"MOBILE":verifyType;
	}
	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}
	public String getVerifyEntity() {
		return verifyEntity;
	}
	public void setVerifyEntity(String verifyEntity) {
		this.verifyEntity = verifyEntity;
	}
	public String getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
	
}
