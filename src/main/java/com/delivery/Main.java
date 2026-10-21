package com.delivery;

import com.delivery.context.AssignmentContext;
import com.delivery.context.PricingContext;
import com.delivery.domain.Customer;
import com.delivery.domain.Order;
import com.delivery.external.SimulatedWeatherService;
import com.delivery.selector.AssignmentSelector;
import com.delivery.selector.PricingSelector;
import com.delivery.strategy.assignment.NearestCourierStrategy;
import com.delivery.strategy.pricing.StandardPricing;

public class Main {
    public static void main(String[] args) {
        SimulatedWeatherService weather = new SimulatedWeatherService();
        Order normalOrder = new Order(5.0, false);
        Customer vipCustomer = new Customer(true);

        System.out.println("--- Manual Strategy Setup ---");
        PricingContext priceContext = new PricingContext(new StandardPricing());
        System.out.println("Standard Price: $" + priceContext.executePricing(normalOrder));

        AssignmentContext assignContext = new AssignmentContext(new NearestCourierStrategy());
        System.out.println("Assigned: " + assignContext.executeAssignment(normalOrder).getName());

        System.out.println("\n--- Selector (Automatic) Setup ---");
        weather.setRaining(true); // Изменили погоду

        PricingSelector priceSelector = new PricingSelector(weather);
        priceContext.setStrategy(priceSelector.selectStrategy(normalOrder));
        System.out.println("Price during rain: $" + priceContext.executePricing(normalOrder));

        AssignmentSelector assignSelector = new AssignmentSelector();
        assignContext.setStrategy(assignSelector.selectStrategy(vipCustomer, false));
        System.out.println("Assigned for VIP: " + assignContext.executeAssignment(normalOrder).getName());
    }
}