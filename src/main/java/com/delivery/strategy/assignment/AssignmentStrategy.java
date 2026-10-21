package com.delivery.strategy.assignment;
import com.delivery.domain.Courier;
import com.delivery.domain.Order;

public interface AssignmentStrategy {
    Courier assignCourier(Order order);
}