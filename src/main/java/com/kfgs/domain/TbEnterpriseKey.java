package com.kfgs.domain;

public class TbEnterpriseKey {
    private Integer productId;

    private String enterpriseName;

    private String approvalAnnouncementNoEnterprise;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getApprovalAnnouncementNoEnterprise() {
        return approvalAnnouncementNoEnterprise;
    }

    public void setApprovalAnnouncementNoEnterprise(String approvalAnnouncementNoEnterprise) {
        this.approvalAnnouncementNoEnterprise = approvalAnnouncementNoEnterprise == null ? null : approvalAnnouncementNoEnterprise.trim();
    }
}