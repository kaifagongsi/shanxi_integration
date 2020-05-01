package com.kfgs.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

public class TbProduct implements Serializable {
    private Integer id;

    private String name;

    private String classificationid;

    private String administrativeArea;

    private Date createTime;

    private Integer isdelete;

    private String approvalYear;

    private String approvalAuthorityProduct;

    private String approvalAnnouncementNoProduct;

    private String approvalAnnouncementNoProductAll;

    private String provinceName;

    private String cityName;

    private String preliminaryExaminationBody;

    private String applicantOrganization;

    private String protectionScope;

    private String documentDefiningTheScopeOfProtection;

    private String technicalSpecifications;

    private String useOfSpecialSigns;


    public TbProduct(){}
    public TbProduct(TbProduct tbProduct){
        this.id = tbProduct.id;
        this.name = tbProduct.getName();
        this.classificationid = tbProduct.getClassificationid();
        this.approvalYear = tbProduct.getApprovalYear();
        this.administrativeArea = tbProduct.getAdministrativeArea();
        this.createTime = tbProduct.getCreateTime();
        this.isdelete = tbProduct.getIsdelete();
        this.approvalAuthorityProduct = tbProduct.getApprovalAuthorityProduct();
        this.approvalAnnouncementNoProduct = tbProduct.getApprovalAnnouncementNoProduct();
        this.approvalAnnouncementNoProductAll = tbProduct.getApprovalAnnouncementNoProductAll();
        this.provinceName = tbProduct.getProvinceName();
        this.cityName = tbProduct.getCityName();
        this.preliminaryExaminationBody = tbProduct.getPreliminaryExaminationBody();
        this.applicantOrganization = tbProduct.getApplicantOrganization();
        this.protectionScope = tbProduct.getProtectionScope();
        this.documentDefiningTheScopeOfProtection = tbProduct.getDocumentDefiningTheScopeOfProtection();
        this.technicalSpecifications = tbProduct.getTechnicalSpecifications();
        this.useOfSpecialSigns = tbProduct.getUseOfSpecialSigns();
    }

    @Override
    public String toString() {
        return "TbProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classificationid='" + classificationid + '\'' +
                ", administrativeArea='" + administrativeArea + '\'' +
                ", createTime=" + createTime +
                ", isdelete=" + isdelete +
                ", approvalYear='" + approvalYear + '\'' +
                ", approvalAuthorityProduct='" + approvalAuthorityProduct + '\'' +
                ", approvalAnnouncementNoProduct='" + approvalAnnouncementNoProduct + '\'' +
                ", approvalAnnouncementNoProductAll='" + approvalAnnouncementNoProductAll + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", preliminaryExaminationBody='" + preliminaryExaminationBody + '\'' +
                ", applicantOrganization='" + applicantOrganization + '\'' +
                ", protectionScope='" + protectionScope + '\'' +
                ", documentDefiningTheScopeOfProtection='" + documentDefiningTheScopeOfProtection + '\'' +
                ", technicalSpecifications='" + technicalSpecifications + '\'' +
                ", useOfSpecialSigns='" + useOfSpecialSigns + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPreliminaryExaminationBody() {
        return preliminaryExaminationBody;
    }

    public void setPreliminaryExaminationBody(String preliminaryExaminationBody) {
        this.preliminaryExaminationBody = preliminaryExaminationBody;
    }

    public String getApplicantOrganization() {
        return applicantOrganization;
    }

    public void setApplicantOrganization(String applicantOrganization) {
        this.applicantOrganization = applicantOrganization;
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
