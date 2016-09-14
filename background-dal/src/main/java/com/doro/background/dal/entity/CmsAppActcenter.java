package com.doro.background.dal.entity;

public class CmsAppActcenter {
    private Long cmsAutoId;

    private String picSrc;

    private String remark;

    private Boolean isAppOpen;

    private Boolean isLogin;

    private String h5Url;

    private String androidKey;

    private String iosKey;

    private Integer sort;

    private Boolean isShow;

    public Long getCmsAutoId() {
        return cmsAutoId;
    }

    public void setCmsAutoId(Long cmsAutoId) {
        this.cmsAutoId = cmsAutoId;
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc == null ? null : picSrc.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsAppOpen() {
        return isAppOpen;
    }

    public void setIsAppOpen(Boolean isAppOpen) {
        this.isAppOpen = isAppOpen;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url == null ? null : h5Url.trim();
    }

    public String getAndroidKey() {
        return androidKey;
    }

    public void setAndroidKey(String androidKey) {
        this.androidKey = androidKey == null ? null : androidKey.trim();
    }

    public String getIosKey() {
        return iosKey;
    }

    public void setIosKey(String iosKey) {
        this.iosKey = iosKey == null ? null : iosKey.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }
}