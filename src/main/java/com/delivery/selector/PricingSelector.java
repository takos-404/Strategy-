package com.delivery.selector;
import com.delivery.PricingStrategy;
import com.delivery.StandardPricing;
import com.delivery.SubscriptionPricing;
import com.delivery.SurgePricing;
import com.delivery.domain.Order;
import com.delivery.external.WeatherService;

public class PricingSelector {
    private final WeatherService weatherService;

    public PricingSelector(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public PricingStrategy selectStrategy(Order order) {
        if (weatherService.isRaining()) {
            return new SurgePricing(weatherService);
        }
        if (order.hasSubscription()) {
            return new SubscriptionPricing();
        }
        return new StandardPricing();
    }
}