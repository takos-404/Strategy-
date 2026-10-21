package com.delivery.strategy.pricing;
import com.delivery.domain.Order;

public class SubscriptionPricing implements PricingStrategy {
    @Override
    public double calculatePrice(Order order) {
        return order.hasSubscription() ? 0.0 : new StandardPricing().calculatePrice(order);
    }
}