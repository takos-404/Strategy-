package com.delivery.strategy.assignment;
import com.delivery.domain.Courier;
import com.delivery.domain.Order;

public class TopRatedStrategy implements AssignmentStrategy {
    @Override
    public Courier assignCourier(Order order) {
        System.out.println("Scanning for available 5-star couriers for VIP order...");
        return new Courier("Sarah (Top Rated)");
    }
}