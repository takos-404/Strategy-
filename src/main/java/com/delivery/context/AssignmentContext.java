package com.delivery.context;
import com.delivery.domain.Courier;
import com.delivery.domain.Order;
import com.delivery.strategy.assignment.AssignmentStrategy;

public class AssignmentContext {
    private AssignmentStrategy strategy;

    public AssignmentContext(AssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public Courier executeAssignment(Order order) {
        return strategy.assignCourier(order);
    }
}