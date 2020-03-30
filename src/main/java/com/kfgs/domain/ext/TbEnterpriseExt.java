package com.kfgs.domain.ext;

import com.kfgs.domain.TbEnterprise;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class TbEnterpriseExt extends TbEnterprise implements Serializable {

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String productName;

}
