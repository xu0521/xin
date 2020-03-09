package com.xuxin.xl050224.dto.in;

public class ReturnHistoryCreateInDTO {

    private Integer returnId;

    private byte returnStatus;

    private Boolean customerNotified;

    private String comment;

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Boolean getCustomerNotified() {
        return customerNotified;
    }

    public void setCustomerNotified(Boolean customerNotified) {
        this.customerNotified = customerNotified;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
