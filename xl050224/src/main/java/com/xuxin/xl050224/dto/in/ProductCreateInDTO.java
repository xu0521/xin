package com.xuxin.xl050224.dto.in;

public class ProductCreateInDTO {

    private String productName;

    private double price;

    private String productAbstract;

    private String productCode;

    private String ProductPicUrl;

    private double discount;

    private String sortOrder;

    private Integer stockQuantity;

    private byte status;

    private String description;

    private String otherPicUrls;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductAbstract() {
        return productAbstract;
    }

    public void setProductAbstract(String productAbstract) {
        this.productAbstract = productAbstract;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductPicUrl() {
        return ProductPicUrl;
    }

    public void setProductPicUrl(String productPicUrl) {
        ProductPicUrl = productPicUrl;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOtherPicUrls() {
        return otherPicUrls;
    }

    public void setOtherPicUrls(String otherPicUrls) {
        this.otherPicUrls = otherPicUrls;
    }
}
