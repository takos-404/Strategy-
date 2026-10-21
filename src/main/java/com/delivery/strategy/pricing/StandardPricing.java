package com.delivery.strategy.pricing;
import com.delivery.domain.Order;

public class StandardPricing implements PricingStrategy {
    @Override
    public double calculatePrice(Order order) {
        return 2.0 + (order.getDistanceKm() * 0.5);
    }
}