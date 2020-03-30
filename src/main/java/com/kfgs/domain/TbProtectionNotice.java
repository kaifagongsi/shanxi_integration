package com.kfgs.domain;

import java.io.Serializable;
import java.util.Date;

public class TbProtectionNotice implements Serializable {
    private Integer id;

    private String title;

    private String titleSimple;

    private Date createTime;

    private Integer isdelete;

    private String typeval;

    private String noticeTime;

    private byte[] content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitleSimple() {
        return titleSimple;
    }

    public void setTitleSimple(String titleSimple) {
        this.titleSimple = titleSimple == null ? null : titleSimple.trim();
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

    public String getTypeval() {
        return typeval;
    }

    public void setTypeval(String typeval) {
        this.typeval = typeval == null ? null : typeval.trim();
    }

    public String getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime == null ? null : noticeTime.trim();
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}