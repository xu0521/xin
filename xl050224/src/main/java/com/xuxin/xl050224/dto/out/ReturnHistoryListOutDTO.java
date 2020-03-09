package com.xuxin.xl050224.dto.out;

public class ReturnHistoryListOutDTO {

    private Long returnHistoryId;

    private Long timestamp;

    private byte returnStatus;

    private String comment;

    private boolean customerNotified;

    public Long getReturnHistoryId() {
        return returnHistoryId;
    }

    public void setReturnHistoryId(Long returnHistoryId) {
        this.returnHistoryId = returnHistoryId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isCustomerNotified() {
        return customerNotified;
    }

    public void setCustomerNotified(boolean customerNotified) {
        this.customerNotified = customerNotified;
    }
}
