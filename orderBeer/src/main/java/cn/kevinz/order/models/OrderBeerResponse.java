package cn.kevinz.order.models;

public class OrderBeerResponse {
    private CheckedStatus checkedStatus;

    private String rejectReason = "";

    public OrderBeerResponse() {}

    public CheckedStatus getCheckedStatus() {
        return checkedStatus;
    }

    public void setCheckedStatus(CheckedStatus checkedStatus) {
        this.checkedStatus = checkedStatus;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}
