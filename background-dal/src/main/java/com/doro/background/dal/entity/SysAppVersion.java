package com.doro.background.dal.entity;

import java.util.Date;

public class SysAppVersion {
	private Long appVersionId;

	private String appClient;

	private Integer appVersionInt;

	private String appVersionStr;

	private Integer enumAppVersionState;

	private Boolean isMust;

	private String remark;

	private String picUrl;

	private Date createTime;

	public Long getAppVersionId() {
		return appVersionId;
	}

	public void setAppVersionId(Long appVersionId) {
		this.appVersionId = appVersionId;
	}

	public String getAppClient() {
		return appClient;
	}

	public void setAppClient(String appClient) {
		this.appClient = appClient == null ? null : appClient.trim();
	}

	public Integer getAppVersionInt() {
		return appVersionInt;
	}

	public void setAppVersionInt(Integer appVersionInt) {
		this.appVersionInt = appVersionInt;
	}

	public String getAppVersionStr() {
		return appVersionStr;
	}

	public void setAppVersionStr(String appVersionStr) {
		this.appVersionStr = appVersionStr == null ? null : appVersionStr.trim();
	}

	public Integer getEnumAppVersionState() {
		return enumAppVersionState;
	}

	public void setEnumAppVersionState(Integer enumAppVersionState) {
		this.enumAppVersionState = enumAppVersionState;
	}

	public Boolean getIsMust() {
		return isMust;
	}

	public void setIsMust(Boolean isMust) {
		this.isMust = isMust;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl == null ? null : picUrl.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 版本
	 * 
	 * @author ZiLing
	 *
	 */
	public enum EnumAppVersionState {
		EDIT(0, "录入中"), REVIEWING(100, "审核中"), FORMAL(200, "正式");

		private int code;
		private String text;

		EnumAppVersionState(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getText(int code) {
			EnumAppVersionState eavs = getByCode(code);
			if (eavs != null)
				return eavs.text;
			return "";
		}

		public static EnumAppVersionState getByCode(int code) {
			for (EnumAppVersionState state : EnumAppVersionState.values()) {
				if (code == state.code)
					return state;
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
}