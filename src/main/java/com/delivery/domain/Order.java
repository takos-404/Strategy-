package com.delivery.domain;

public class Order {
    private final double distanceKm;
    private final boolean customerHasSubscription;

    public Order(double distanceKm, boolean customerHasSubscription) {
        this.distanceKm = distanceKm;
        this.customerHasSubscription = customerHasSubscription;
    }

    public double getDistanceKm() { return distanceKm; }
    public boolean hasSubscription() { return customerHasSubscription; }
}