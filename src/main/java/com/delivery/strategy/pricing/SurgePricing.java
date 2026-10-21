package com.delivery.strategy.pricing;
import com.delivery.domain.Order;
import com.delivery.external.WeatherService;

public class SurgePricing implements PricingStrategy {
    private final WeatherService weatherService;

    public SurgePricing(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public double calculatePrice(Order order) {
        double basePrice = 2.0 + (order.getDistanceKm() * 0.5);
        return weatherService.isRaining() ? basePrice * 2.5 : basePrice;
    }
}