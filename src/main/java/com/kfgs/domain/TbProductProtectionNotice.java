package com.kfgs.domain;

import java.io.Serializable;
import java.util.Date;

public class TbProductProtectionNotice implements Serializable {
    private Integer id;

    private String productId;

    private String protectionNoticeId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProtectionNoticeId() {
        return protectionNoticeId;
    }

    public void setProtectionNoticeId(String protectionNoticeId) {
        this.protectionNoticeId = protectionNoticeId == null ? null : protectionNoticeId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}