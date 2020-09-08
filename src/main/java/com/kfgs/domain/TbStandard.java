package com.kfgs.domain;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class TbStandard implements Serializable {
    private Integer id;

    private String productName;

    private String standardNumber;

    private String standardName;

    private String address;

    private String state;

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

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



}