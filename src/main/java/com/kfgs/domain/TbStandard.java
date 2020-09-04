package com.kfgs.domain;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class TbStandard {
    private Integer id;

    private String productName;

    private String standardNumber;

    private String standardName;

    private String address;

    private String state;

    @JSONField(format="yyyy-MM-dd")
    private Date publishTime;

    @JSONField(format="yyyy-MM-dd")
    private Date implementTime;

    private String recordNumber;
    @JSONField(format="yyyy-MM-dd")
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

    private String limitation;

    private String drafter;

    private String draftUnit;

  /*  public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getStandardNumber() {
        return standardNumber;
    }

    public void setStandardNumber(String standardNumber) {
        this.standardNumber = standardNumber == null ? null : standardNumber.trim();
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName == null ? null : standardName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
        this.recordNumber = recordNumber == null ? null : recordNumber.trim();
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
        this.type = type == null ? null : type.trim();
    }

    public String getSettingOrRevision() {
        return settingOrRevision;
    }

    public void setSettingOrRevision(String settingOrRevision) {
        this.settingOrRevision = settingOrRevision == null ? null : settingOrRevision.trim();
    }

    public String getReplaceStandard() {
        return replaceStandard;
    }

    public void setReplaceStandard(String replaceStandard) {
        this.replaceStandard = replaceStandard == null ? null : replaceStandard.trim();
    }

    public String getChinaStandard() {
        return chinaStandard;
    }

    public void setChinaStandard(String chinaStandard) {
        this.chinaStandard = chinaStandard == null ? null : chinaStandard.trim();
    }

    public String getInternationalStandard() {
        return internationalStandard;
    }

    public void setInternationalStandard(String internationalStandard) {
        this.internationalStandard = internationalStandard == null ? null : internationalStandard.trim();
    }

    public String getTechniqueShall() {
        return techniqueShall;
    }

    public void setTechniqueShall(String techniqueShall) {
        this.techniqueShall = techniqueShall == null ? null : techniqueShall.trim();
    }

    public String getApprovalReleaseDepartment() {
        return approvalReleaseDepartment;
    }

    public void setApprovalReleaseDepartment(String approvalReleaseDepartment) {
        this.approvalReleaseDepartment = approvalReleaseDepartment == null ? null : approvalReleaseDepartment.trim();
    }

    public String getIndustryClassification() {
        return industryClassification;
    }

    public void setIndustryClassification(String industryClassification) {
        this.industryClassification = industryClassification == null ? null : industryClassification.trim();
    }

    public String getStandardType() {
        return standardType;
    }

    public void setStandardType(String standardType) {
        this.standardType = standardType == null ? null : standardType.trim();
    }

    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation == null ? null : limitation.trim();
    }

    public String getDrafter() {
        return drafter;
    }

    public void setDrafter(String drafter) {
        this.drafter = drafter == null ? null : drafter.trim();
    }

    public String getDraftUnit() {
        return draftUnit;
    }

    public void setDraftUnit(String draftUnit) {
        this.draftUnit = draftUnit == null ? null : draftUnit.trim();
    }*/
}