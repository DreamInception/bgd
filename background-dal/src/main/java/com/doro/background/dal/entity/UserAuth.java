package com.doro.background.dal.entity;

public class UserAuth {
    private Long userId;

    private String realName;

    private String certId;

    private Boolean realNameChecked;

    private String userMobile;

    private Boolean userMobileChecked;

    private String userEmail;

    private Boolean userEmailChecked;
    
    private UserSina userSina;
    

    public UserSina getUserSina() {
		return userSina;
	}

	public void setUserSina(UserSina userSina) {
		this.userSina = userSina;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId == null ? null : certId.trim();
    }

    public Boolean getRealNameChecked() {
        return realNameChecked;
    }

    public void setRealNameChecked(Boolean realNameChecked) {
        this.realNameChecked = realNameChecked;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Boolean getUserMobileChecked() {
        return userMobileChecked;
    }

    public void setUserMobileChecked(Boolean userMobileChecked) {
        this.userMobileChecked = userMobileChecked;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Boolean getUserEmailChecked() {
        return userEmailChecked;
    }

    public void setUserEmailChecked(Boolean userEmailChecked) {
        this.userEmailChecked = userEmailChecked;
    }
}