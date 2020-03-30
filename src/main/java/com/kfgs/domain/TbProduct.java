package com.kfgs.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
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
}