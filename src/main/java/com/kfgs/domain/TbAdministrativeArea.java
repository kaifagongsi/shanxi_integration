package com.kfgs.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class TbAdministrativeArea extends TbAdministrativeAreaKey implements Serializable {
    private String name;

    private String parentId;

    private String path;

    private Integer level;

    private Integer isdelete;

    private Date createTime;


}