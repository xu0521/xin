package com.xuxin.xl050224storeback.dto.out;

public class OrderProductShowOutOUT {

    private Integer productId;

    private String productCode;

    private String productName;

    private Integer quantity;

    private double unitPrice;

    private Integer  unitRewordPoints;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitRewordPoints() {
        return unitRewordPoints;
    }

    public void setUnitRewordPoints(Integer unitRewordPoints) {
        this.unitRewordPoints = unitRewordPoints;
    }
}
