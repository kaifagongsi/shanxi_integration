package com.kfgs.domain.ext;

import com.kfgs.domain.TbRelatedWebsites;

/**
 * Date: 2020-05-08-17-03
 * Module:
 * Description:
 *
 * @author:
 */
public class TbRelatedWebsitesExt extends TbRelatedWebsites {
    private String productName;

    public TbRelatedWebsitesExt(){
    }
    public TbRelatedWebsitesExt(String productName,TbRelatedWebsites tbRelatedWebsites){
        super();
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
