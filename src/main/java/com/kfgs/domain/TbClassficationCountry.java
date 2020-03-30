package com.kfgs.domain;

import java.io.Serializable;
import java.util.Date;

public class TbClassficationCountry implements Serializable {
    private Integer id;

    private String name;

    private String rootid;

    private String classificationid;

    private String parentid;

    private String content;

    private Date createTime;

    private Integer isdelete;

    private String level;

    private String reserve;

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
        this.name = name == null ? null : name.trim();
    }

    public String getRootid() {
        return rootid;
    }

    public void setRootid(String rootid) {
        this.rootid = rootid == null ? null : rootid.trim();
    }

    public String getClassificationid() {
        return classificationid;
    }

    public void setClassificationid(String classificationid) {
        this.classificationid = classificationid == null ? null : classificationid.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }
}