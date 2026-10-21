package com.delivery.strategy.assignment;
import com.delivery.domain.Courier;
import com.delivery.domain.Order;

public class NearestCourierStrategy implements AssignmentStrategy {
    @Override
    public Courier assignCourier(Order order) {
        System.out.println("Finding the nearest courier based on GPS coordinates...");
        return new Courier("John (Nearest)");
    }
}