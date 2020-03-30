package com.kfgs.domain;

import java.io.Serializable;

public class TbAdministrativeAreaKey implements Serializable {
    private Integer id;

    private String cityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }
}