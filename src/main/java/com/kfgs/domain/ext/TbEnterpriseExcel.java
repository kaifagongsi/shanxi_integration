package com.kfgs.domain.ext;

import java.util.Date;

/**
 * Date: 2020-04-22-09-35
 * Module:
 * Description:
 *
 * @author:
 */
public class TbEnterpriseExcel {

    private Date createTime;

    private Integer isdelete;

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    private String enterpriseName;

    private String enterpriseAddress;

    private String administrativeId;

    private String productName;

    private String corporateRepresentative;

    private String uniformSocialCreditCode;

    private String approvalAnnouncementNoEnterprise;

    private String approvalAnnouncementNoEnterpriseAll;

    private String approvalAuthorityEnterprise;

    private String approvalYear;

    private String isFirstSubmission;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getAdministrativeId() {
        return administrativeId;
    }

    public void setAdministrativeId(String administrativeId) {
        this.administrativeId = administrativeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCorporateRepresentative() {
        return corporateRepresentative;
    }

    public void setCorporateRepresentative(String corporateRepresentative) {
        this.corporateRepresentative = corporateRepresentative;
    }

    public String getUniformSocialCreditCode() {
        return uniformSocialCreditCode;
    }

    public void setUniformSocialCreditCode(String uniformSocialCreditCode) {
        this.uniformSocialCreditCode = uniformSocialCreditCode;
    }

    public String getApprovalAnnouncementNoEnterprise() {
        return approvalAnnouncementNoEnterprise;
    }

    public void setApprovalAnnouncementNoEnterprise(String approvalAnnouncementNoEnterprise) {
        this.approvalAnnouncementNoEnterprise = approvalAnnouncementNoEnterprise;
    }

    public String getApprovalAnnouncementNoEnterpriseAll() {
        return approvalAnnouncementNoEnterpriseAll;
    }

    public void setApprovalAnnouncementNoEnterpriseAll(String approvalAnnouncementNoEnterpriseAll) {
        this.approvalAnnouncementNoEnterpriseAll = approvalAnnouncementNoEnterpriseAll;
    }

    public String getApprovalAuthorityEnterprise() {
        return approvalAuthorityEnterprise;
    }

    public void setApprovalAuthorityEnterprise(String approvalAuthorityEnterprise) {
        this.approvalAuthorityEnterprise = approvalAuthorityEnterprise;
    }

    public String getApprovalYear() {
        return approvalYear;
    }

    public void setApprovalYear(String approvalYear) {
        this.approvalYear = approvalYear;
    }

    public String getIsFirstSubmission() {
        return isFirstSubmission;
    }

    public void setIsFirstSubmission(String isFirstSubmission) {
        this.isFirstSubmission = isFirstSubmission;
    }
}
