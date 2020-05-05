package com.kfgs.domain.ext;

import com.kfgs.domain.TbEnterprise;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class TbEnterpriseExt extends TbEnterprise implements Serializable {

    private String productName;

    private String city;

    public TbEnterpriseExt() {
    }

    public TbEnterpriseExt(String productName, TbEnterprise tbEnterprise){
        super(tbEnterprise);
        this.productName = productName;
    }

    public TbEnterpriseExt(String  city,String productName, TbEnterprise tbEnterprise){
        super(tbEnterprise);
        this.city = city;
        this.productName = productName;
    }
}
