package com.doro.background.sina.entity;

public class ShowMemberInfosSina {
	private String identityId;
	private String identityType;
	private String defaultPage;
	private String templetCustom;
	private String singleCustom;
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
	public String getRespMethod() {
		return "1";
	}
	public void setRespMethod(String respMethod) {
	}
	public String getDefaultPage() {
		return defaultPage==null?"DEFAULT":defaultPage;
	}
	public void setDefaultPage(String defaultPage) {
		this.defaultPage = defaultPage;
	}
	public String getHidePage() {
		return "WITHHOLD";
	}
	public void setHidePage(String hidePage) {
	}
	public String getTempletCustom() {
		return templetCustom;
	}
	public void setTempletCustom(String templetCustom) {
		this.templetCustom = templetCustom;
	}
	public String getSingleCustom() {
		return singleCustom;
	}
	public void setSingleCustom(String singleCustom) {
		this.singleCustom = singleCustom;
	}
	public String getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
	
}
