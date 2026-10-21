package com.delivery.selector;
import com.delivery.strategy.pricing.PricingStrategy;
import com.delivery.strategy.pricing.StandardPricing;
import com.delivery.strategy.pricing.SubscriptionPricing;
import com.delivery.strategy.pricing.SurgePricing;
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