package com.business.model;

/**
 * Created by User on 25/09/2015.
 */
public class SubscriptionModel extends BaseModel{
    private String PlanDescription;
    private String NumberMonthsYear;
    private String Rate;
    private String TotalAmount;
    private String PaypalAccount;
    private String StartDate;
    private String EndDate;

    public SubscriptionModel() {
    }

    public String getPlanDescription() {
        return PlanDescription;
    }

    public void setPlanDescription(String planDescription) {
        PlanDescription = planDescription;
    }

    public String getNumberMonthsYear() {
        return NumberMonthsYear;
    }

    public void setNumberMonthsYear(String numberMonthsYear) {
        NumberMonthsYear = numberMonthsYear;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getPaypalAccount() {
        return PaypalAccount;
    }

    public void setPaypalAccount(String paypalAccount) {
        PaypalAccount = paypalAccount;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }
}
