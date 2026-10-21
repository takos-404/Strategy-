package com.delivery.selector;
import com.delivery.domain.Customer;
import com.delivery.strategy.assignment.*;

public class AssignmentSelector {
    public AssignmentStrategy selectStrategy(Customer customer, boolean highDemand) {
        if (customer.isVip()) {
            return new TopRatedStrategy();
        }
        if (highDemand) {
            return new BatchedStrategy();
        }
        return new NearestCourierStrategy();
    }
}