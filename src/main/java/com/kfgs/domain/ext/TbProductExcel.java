package com.kfgs.domain.ext;

import java.util.Date;

/**
 * Date: 2020-04-21-09-56
 * Module:
 * Description:
 *
 * @author:
 */
public class TbProductExcel {

    private Date createDate;

    private  Integer isdelete;

    private Integer id;

    private String name;

    private String classificationid;

    private String administrativeArea;

    /**
     * 申请机构
     */
    private String applicantOrganization;

    /**
     * 初审机构
     */
    private String preliminaryExaminationBody;

    /**
     * 受理年度
     */
    private String acceptanceYear;
    /**
     * 受理公告
     */
    private String acceptanceAnnouncement;
    /**
     * 批准年度
     */
    private String approvalYear;
    /**
     * 批准机构
     */
    private String approvalAuthorityProduct;
    /**
     * 批准公告简称
     */
    private String approvalAnnouncementNoProduct;
    /**
     * 批准公告全称
     */
    private String approvalAnnouncementNoProductAll;

    /**
     * 省份
     */
    private String provinceName;

    /**
     * 地市+区县
     */
    private String cityName;
    /**
     * 保护范围
     */
    private String protectionScope;
    /**
     * 界定保护范围文件
     */
    private String documentDefiningTheScopeOfProtection;
    /**
     * 技术规范
     */
    private String technicalSpecifications;
    /**
     * 专用标志使用
     */
    private String useOfSpecialSigns;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassificationid() {
        return classificationid;
    }

    public void setClassificationid(String classificationid) {
        this.classificationid = classificationid;
    }

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    public String getApplicantOrganization() {
        return applicantOrganization;
    }

    public void setApplicantOrganization(String applicantOrganization) {
        this.applicantOrganization = applicantOrganization;
    }

    public String getPreliminaryExaminationBody() {
        return preliminaryExaminationBody;
    }

    public void setPreliminaryExaminationBody(String preliminaryExaminationBody) {
        this.preliminaryExaminationBody = preliminaryExaminationBody;
    }

    public String getAcceptanceYear() {
        return acceptanceYear;
    }

    public void setAcceptanceYear(String acceptanceYear) {
        this.acceptanceYear = acceptanceYear;
    }

    public String getAcceptanceAnnouncement() {
        return acceptanceAnnouncement;
    }

    public void setAcceptanceAnnouncement(String acceptanceAnnouncement) {
        this.acceptanceAnnouncement = acceptanceAnnouncement;
    }

    public String getApprovalYear() {
        return approvalYear;
    }

    public void setApprovalYear(String approvalYear) {
        this.approvalYear = approvalYear;
    }

    public String getApprovalAuthorityProduct() {
        return approvalAuthorityProduct;
    }

    public void setApprovalAuthorityProduct(String approvalAuthorityProduct) {
        this.approvalAuthorityProduct = approvalAuthorityProduct;
    }

    public String getApprovalAnnouncementNoProduct() {
        return approvalAnnouncementNoProduct;
    }

    public void setApprovalAnnouncementNoProduct(String approvalAnnouncementNoProduct) {
        this.approvalAnnouncementNoProduct = approvalAnnouncementNoProduct;
    }

    public String getApprovalAnnouncementNoProductAll() {
        return approvalAnnouncementNoProductAll;
    }

    public void setApprovalAnnouncementNoProductAll(String approvalAnnouncementNoProductAll) {
        this.approvalAnnouncementNoProductAll = approvalAnnouncementNoProductAll;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProtectionScope() {
        return protectionScope;
    }

    public void setProtectionScope(String protectionScope) {
        this.protectionScope = protectionScope;
    }

    public String getDocumentDefiningTheScopeOfProtection() {
        return documentDefiningTheScopeOfProtection;
    }

    public void setDocumentDefiningTheScopeOfProtection(String documentDefiningTheScopeOfProtection) {
        this.documentDefiningTheScopeOfProtection = documentDefiningTheScopeOfProtection;
    }

    public String getTechnicalSpecifications() {
        return technicalSpecifications;
    }

    public void setTechnicalSpecifications(String technicalSpecifications) {
        this.technicalSpecifications = technicalSpecifications;
    }

    public String getUseOfSpecialSigns() {
        return useOfSpecialSigns;
    }

    public void setUseOfSpecialSigns(String useOfSpecialSigns) {
        this.useOfSpecialSigns = useOfSpecialSigns;
    }
}
