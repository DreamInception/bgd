package com.doro.background.dal.entity;

import java.util.Date;

public class UserLogin {
	private Long userId;

	private String userName;

	private String userMobile;

	private String userEmail;

	private String userPwd;

	private String pwdSalt;

	private Integer enumUserState;

	private Date regDate;

	private String regIp;

	private Date createTime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd == null ? null : userPwd.trim();
	}

	public String getPwdSalt() {
		return pwdSalt;
	}

	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt == null ? null : pwdSalt.trim();
	}

	public Integer getEnumUserState() {
		return enumUserState;
	}

	public void setEnumUserState(Integer enumUserState) {
		this.enumUserState = enumUserState;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp == null ? null : regIp.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 
	 * 鐢ㄦ埛璐︽埛鐘舵��
	 *
	 */
	public enum EnumUserState {
		NORMAL(0, "姝ｅ父"), FROZEN(100, "鍐荤粨");

		private int code;
		private String text;

		EnumUserState(int code, String text) {
			this.code = code;
			this.text = text;
		}

		public static String getText(int code) {
			EnumUserState eus = getByCode(code);
			if (eus != null)
				return eus.text;
			return "";
		}

		public static EnumUserState getByCode(int code) {
			for (EnumUserState state : EnumUserState.values()) {
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