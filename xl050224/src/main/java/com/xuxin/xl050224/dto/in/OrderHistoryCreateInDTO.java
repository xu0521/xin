package com.xuxin.xl050224.dto.in;

public class OrderHistoryCreateInDTO {

    private Long orderId;

    private byte orderStatus;

    private String comment;

    private boolean customerNotified;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(byte orderStatus) {
        this.orderStatus = orderStatus;
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
