package com.delivery.strategy.pricing;
import com.delivery.external.WeatherService;
import com.delivery.domain.Order;
import com.delivery.external.WeatherService;

public class BadPricingCalculator {
    private final WeatherService weatherService;

    public BadPricingCalculator(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Ужасный метод, нарушающий Open/Closed Principle:
    public double calculatePrice(Order order, String type) {
        if ("SUBSCRIPTION".equals(type)) {
            if (order.hasSubscription()) {
                return 0.0;
            }
            return 2.0 + (order.getDistanceKm() * 0.5); // fallback to standard
        } else if ("SURGE".equals(type)) {
            double basePrice = 2.0 + (order.getDistanceKm() * 0.5);
            if (weatherService.isRaining()) {
                return basePrice * 2.5; // дождь - множитель x2.5
            }
            return basePrice;
        } else if ("STANDARD".equals(type)) {
            return 2.0 + (order.getDistanceKm() * 0.5);
        }

        throw new IllegalArgumentException("Unknown pricing type");
    }
}