package com.delivery.strategy.pricing;
import com.delivery.domain.Order;

public interface PricingStrategy {
    double calculatePrice(Order order);
}