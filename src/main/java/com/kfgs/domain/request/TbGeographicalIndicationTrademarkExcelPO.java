package com.kfgs.domain.request;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class TbGeographicalIndicationTrademarkExcelPO {
    private String tradeName;

    private String trademarkType;

    private String chineseNameOfRegisrant;

    private String registrationNumber;

    private Integer internationalClassification;
    @JSONField(format="yyyy-MM-dd")
    private Date applicationDate;

    private String chineseAddressOfRegistrant;

    private String nameOfAgency;

    private Integer issueNumOfPreliminaryExaminationAnnouncement;
    @JSONField(format="yyyy-MM-dd")
    private Date announcementDateOfPreliminaryExamination;

    private Integer regeistrationNoticeIssueNo;
    @JSONField(format="yyyy-MM-dd")
    private Date dateOfBoticeOfRegeistation;

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTrademarkType() {
        return trademarkType;
    }

    public void setTrademarkType(String trademarkType) {
        this.trademarkType = trademarkType;
    }

    public String getChineseNameOfRegisrant() {
        return chineseNameOfRegisrant;
    }

    public void setChineseNameOfRegisrant(String chineseNameOfRegisrant) {
        this.chineseNameOfRegisrant = chineseNameOfRegisrant;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getInternationalClassification() {
        return internationalClassification;
    }

    public void setInternationalClassification(Integer internationalClassification) {
        this.internationalClassification = internationalClassification;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getChineseAddressOfRegistrant() {
        return chineseAddressOfRegistrant;
    }

    public void setChineseAddressOfRegistrant(String chineseAddressOfRegistrant) {
        this.chineseAddressOfRegistrant = chineseAddressOfRegistrant;
    }

    public String getNameOfAgency() {
        return nameOfAgency;
    }

    public void setNameOfAgency(String nameOfAgency) {
        this.nameOfAgency = nameOfAgency;
    }

    public Integer getIssueNumOfPreliminaryExaminationAnnouncement() {
        return issueNumOfPreliminaryExaminationAnnouncement;
    }

    public void setIssueNumOfPreliminaryExaminationAnnouncement(Integer issueNumOfPreliminaryExaminationAnnouncement) {
        this.issueNumOfPreliminaryExaminationAnnouncement = issueNumOfPreliminaryExaminationAnnouncement;
    }

    public Date getAnnouncementDateOfPreliminaryExamination() {
        return announcementDateOfPreliminaryExamination;
    }

    public void setAnnouncementDateOfPreliminaryExamination(Date announcementDateOfPreliminaryExamination) {
        this.announcementDateOfPreliminaryExamination = announcementDateOfPreliminaryExamination;
    }

    public Integer getRegeistrationNoticeIssueNo() {
        return regeistrationNoticeIssueNo;
    }

    public void setRegeistrationNoticeIssueNo(Integer regeistrationNoticeIssueNo) {
        this.regeistrationNoticeIssueNo = regeistrationNoticeIssueNo;
    }

    public Date getDateOfBoticeOfRegeistation() {
        return dateOfBoticeOfRegeistation;
    }

    public void setDateOfBoticeOfRegeistation(Date dateOfBoticeOfRegeistation) {
        this.dateOfBoticeOfRegeistation = dateOfBoticeOfRegeistation;
    }
}
