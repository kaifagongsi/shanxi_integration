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

    private String[] ent;

    private String[] web;


    public String[] getWeb() {
        return web;
    }

    public void setWeb(String[] web) {
        this.web = web;
    }

    public String[] getEnt() {
        return ent;
    }

    public void setEnt(String[] ent) {
        this.ent = ent;
    }

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
