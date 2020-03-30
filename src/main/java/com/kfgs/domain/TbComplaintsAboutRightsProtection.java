package com.kfgs.domain;

import java.io.Serializable;
import java.util.Date;

public class TbComplaintsAboutRightsProtection implements Serializable {
    private Integer id;

    private String objectOfComplaint;

    private String detailsOfComplaints;

    private Double amountOfComplaint;

    private String pathOfEvidenceUpload;

    private String state;

    private String handlingSituation;

    private String complainant;

    private String contact;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjectOfComplaint() {
        return objectOfComplaint;
    }

    public void setObjectOfComplaint(String objectOfComplaint) {
        this.objectOfComplaint = objectOfComplaint == null ? null : objectOfComplaint.trim();
    }

    public String getDetailsOfComplaints() {
        return detailsOfComplaints;
    }

    public void setDetailsOfComplaints(String detailsOfComplaints) {
        this.detailsOfComplaints = detailsOfComplaints == null ? null : detailsOfComplaints.trim();
    }

    public Double getAmountOfComplaint() {
        return amountOfComplaint;
    }

    public void setAmountOfComplaint(Double amountOfComplaint) {
        this.amountOfComplaint = amountOfComplaint;
    }

    public String getPathOfEvidenceUpload() {
        return pathOfEvidenceUpload;
    }

    public void setPathOfEvidenceUpload(String pathOfEvidenceUpload) {
        this.pathOfEvidenceUpload = pathOfEvidenceUpload == null ? null : pathOfEvidenceUpload.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getHandlingSituation() {
        return handlingSituation;
    }

    public void setHandlingSituation(String handlingSituation) {
        this.handlingSituation = handlingSituation == null ? null : handlingSituation.trim();
    }

    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant == null ? null : complainant.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}