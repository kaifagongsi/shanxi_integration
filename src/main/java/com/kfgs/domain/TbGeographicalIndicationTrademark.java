package com.kfgs.domain;

import java.util.Date;

public class TbGeographicalIndicationTrademark {
    private Integer id;

    private String registrationNumber;

    private Integer internationalClassification;

    private Date applicationDate;

    private String chineseAddressOfRegistrant;

    private String nameOfAgency;

    private Integer issueNumOfPreliminaryExaminationAnnouncement;

    private Date announcementDateOfPreliminaryExamination;

    private Integer regeistrationNoticeIssueNo;

    private Date dateOfBoticeOfRegeistation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber == null ? null : registrationNumber.trim();
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
        this.chineseAddressOfRegistrant = chineseAddressOfRegistrant == null ? null : chineseAddressOfRegistrant.trim();
    }

    public String getNameOfAgency() {
        return nameOfAgency;
    }

    public void setNameOfAgency(String nameOfAgency) {
        this.nameOfAgency = nameOfAgency == null ? null : nameOfAgency.trim();
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