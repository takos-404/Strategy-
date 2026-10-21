package com.delivery.strategy.assignment;
import com.delivery.domain.Courier;
import com.delivery.domain.Order;

public class BatchedStrategy implements AssignmentStrategy {
    @Override
    public Courier assignCourier(Order order) {
        System.out.println("Looking for a courier already heading to the same neighborhood...");
        return new Courier("Mike (Batched)");
    }
}