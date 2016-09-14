package com.doro.background.dal.entity;

public class DqTargetDetail {
    private Long targetId;

    private String sellerName;

    private String dqContent;

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    public String getDqContent() {
        return dqContent;
    }

    public void setDqContent(String dqContent) {
        this.dqContent = dqContent == null ? null : dqContent.trim();
    }
}