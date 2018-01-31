package cn.kevinz.order.models;

public class OrderBeerApplicationResult {
    private OrderBeerApplicationStatus orderBeerApplicationStatus;

    private String rejectReason;

    public OrderBeerApplicationResult() {
    }

    public OrderBeerApplicationResult(OrderBeerApplicationStatus orderBeerApplicationStatus, String rejectReason) {
        this.orderBeerApplicationStatus = orderBeerApplicationStatus;
        this.rejectReason = rejectReason;
    }

    public OrderBeerApplicationStatus getOrderBeerApplicationStatus() {
        return orderBeerApplicationStatus;
    }

    public void setOrderBeerApplicationStatus(OrderBeerApplicationStatus orderBeerApplicationStatus) {
        this.orderBeerApplicationStatus = orderBeerApplicationStatus;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}
