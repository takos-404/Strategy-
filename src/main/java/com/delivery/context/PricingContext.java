package com.delivery.context;
import com.delivery.domain.Order;
import com.delivery.PricingStrategy;

public class PricingContext {
    private PricingStrategy strategy;

    public PricingContext(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double executePricing(Order order) {
        return strategy.calculatePrice(order);
    }
}