package com.xuxin.xl050224.dto.in;

public class CustomerSetStatusInDTO {

    private Integer customerId;

    private byte status;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
