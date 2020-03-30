package com.kfgs.domain;

import java.io.Serializable;
import java.util.Date;

public class TbPolicyDocument implements Serializable {
    private Integer id;

    private String title;

    private Date createTime;

    private Integer isdelete;

    private String typeval;

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}