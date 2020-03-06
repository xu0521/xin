package com.xuxin.xl050224.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class OrderListOutDTO {

    private Long orderId;

    private Integer customerId;

    private String customerName;

    private byte status;

    private double totalPrice;

    @JsonIgnore
    private Date createTime;

    private Long createTimestamp;

    @JsonIgnore
    private Date updateTime;

    private Long updateTimestamp;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getCreateTimestamp() {
        return this.createTime == null ? null : this.createTime.getTime();
    }

    public Long getUpdateTimestamp() {
        return this.updateTime == null ? null : this.updateTime.getTime();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
