package cn.kevinz.provider.model;

public class IndentCheckResult {
    private CheckedStatus checkedStatus;
    private String rejectReason;
    private Boolean orderStatus;

    public IndentCheckResult() {}

    public IndentCheckResult(CheckedStatus checkedStatus, String rejectReason, Boolean orderStatus) {
        this.checkedStatus = checkedStatus;
        this.rejectReason = rejectReason;
        this.orderStatus = orderStatus;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public CheckedStatus getCheckedStatus() {
        return checkedStatus;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }
}
