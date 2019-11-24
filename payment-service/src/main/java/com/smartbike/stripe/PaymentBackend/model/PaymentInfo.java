package com.smartbike.stripe.PaymentBackend.model;

public class PaymentInfo {
    private String token;
    private int amount;

    public PaymentInfo() {
    }

    public PaymentInfo(String token, int amount) {
        this.token = token;
        this.amount = amount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
