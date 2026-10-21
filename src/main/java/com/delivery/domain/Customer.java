package com.delivery.domain;

public class Customer {
    private final boolean isVip;
    public Customer(boolean isVip) { this.isVip = isVip; }
    public boolean isVip() { return isVip; }
}