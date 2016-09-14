package com.doro.background.sina.entity;

public class SetRealName {
	private String identityId;
	private String realName;
	private String identityType;
	private String certType;
	private String certNo;
	private String needConfirm;
	private String extendParam;
	public String getIdentityId() {
		return identityId;
	}
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdentityType() {
		return identityType==null?"UID":identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
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
	public String getNeedConfirm() {
		return needConfirm;
	}
	public void setNeedConfirm(String needConfirm) {
		this.needConfirm = needConfirm;
	}
	public String getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
}
