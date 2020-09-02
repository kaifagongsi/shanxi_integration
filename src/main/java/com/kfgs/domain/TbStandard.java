package com.kfgs.domain;


import java.io.Serializable;
import java.util.Date;

public class TbStandard implements Serializable {
    private Integer id;

    private String productName;

    private String standardNumber;

    private String standardName;

    private String address;

    private String state;

    private Date publishTime;

    private Date implementTime;

    private String recordNumber;

    private Date recordTime;

    private String type;

    private String settingOrRevision;

    private String replaceStandard;

    private String chinaStandard;

    private String internationalStandard;

    private String techniqueShall;

    private String approvalReleaseDepartment;

    private String industryClassification;

    private String standardType;


    public TbStandard(){

    }

    public TbStandard(TbStandard tbStandard){
        this.id = tbStandard.getId();
        this.productName = tbStandard.getProductName();
        this.standardNumber = tbStandard.getStandardNumber();
        this.standardName = tbStandard.getStandardName();
        this.address = tbStandard.getAddress();
        this.state = tbStandard.getState();
        this.publishTime = tbStandard.getPublishTime();
        this.implementTime = tbStandard.getImplementTime();
        this.recordNumber = tbStandard.getRecordNumber();
        this.recordTime = tbStandard.getRecordTime();
        this.type = tbStandard.getType();
        this.settingOrRevision = tbStandard.getSettingOrRevision();
        this.replaceStandard = tbStandard.getReplaceStandard();
        this.chinaStandard = tbStandard.getChinaStandard();
        this.internationalStandard = tbStandard.getInternationalStandard();
        this.techniqueShall = tbStandard.getTechniqueShall();
        this.approvalReleaseDepartment = tbStandard.getApprovalReleaseDepartment();
        this.industryClassification = tbStandard.getIndustryClassification();
        this.standardType = tbStandard.getStandardType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStandardNumber() {
        return standardNumber;
    }

    public void setStandardNumber(String standardNumber) {
        this.standardNumber = standardNumber;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getImplementTime() {
        return implementTime;
    }

    public void setImplementTime(Date implementTime) {
        this.implementTime = implementTime;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSettingOrRevision() {
        return settingOrRevision;
    }

    public void setSettingOrRevision(String settingOrRevision) {
        this.settingOrRevision = settingOrRevision;
    }

    public String getReplaceStandard() {
        return replaceStandard;
    }

    public void setReplaceStandard(String replaceStandard) {
        this.replaceStandard = replaceStandard;
    }

    public String getChinaStandard() {
        return chinaStandard;
    }

    public void setChinaStandard(String chinaStandard) {
        this.chinaStandard = chinaStandard;
    }

    public String getInternationalStandard() {
        return internationalStandard;
    }

    public void setInternationalStandard(String internationalStandard) {
        this.internationalStandard = internationalStandard;
    }

    public String getTechniqueShall() {
        return techniqueShall;
    }

    public void setTechniqueShall(String techniqueShall) {
        this.techniqueShall = techniqueShall;
    }

    public String getApprovalReleaseDepartment() {
        return approvalReleaseDepartment;
    }

    public void setApprovalReleaseDepartment(String approvalReleaseDepartment) {
        this.approvalReleaseDepartment = approvalReleaseDepartment;
    }

    public String getIndustryClassification() {
        return industryClassification;
    }

    public void setIndustryClassification(String industryClassification) {
        this.industryClassification = industryClassification;
    }

    public String getStandardType() {
        return standardType;
    }

    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }

    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }

    public String getDrafter() {
        return drafter;
    }

    public void setDrafter(String drafter) {
        this.drafter = drafter;
    }

    public String getDraftUnit() {
        return draftUnit;
    }

    public void setDraftUnit(String draftUnit) {
        this.draftUnit = draftUnit;
    }

    private String limitation;

    private String drafter;

    private String draftUnit;




}
