package com.kfgs.domain.ext;

import com.kfgs.domain.TbEnterprise;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class TbEnterpriseExt extends TbEnterprise implements Serializable {

    private String productName;

    public TbEnterpriseExt() {
    }

    public TbEnterpriseExt(String productName, TbEnterprise tbEnterprise){
        super(tbEnterprise);
        this.productName = productName;
    }
}
