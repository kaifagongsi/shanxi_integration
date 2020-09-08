package com.kfgs.domain;

public class TbProductLandmark {
    private Integer id;

    private String productName;

    private String city;

    private String county;

    private String productNumber;

    private String certificateHolder;

    private String registerYear;

    private String industry;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    public String getCertificateHolder() {
        return certificateHolder;
    }

    public void setCertificateHolder(String certificateHolder) {
        this.certificateHolder = certificateHolder == null ? null : certificateHolder.trim();
    }

    public String getRegisterYear() {
        return registerYear;
    }

    public void setRegisterYear(String registerYear) {
        this.registerYear = registerYear == null ? null : registerYear.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}