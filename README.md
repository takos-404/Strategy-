# Assignment 5: Strategy Pattern (Food Delivery Domain)

## 1. Class Responsibilities (Single Responsibility Principle)

| Class | Responsibility (Max 25 words, no if/and/or/but) |
| :--- | :--- |
| **StandardPricing** | Calculates standard delivery cost based on route distance. |
| **SurgePricing** | Increases base delivery cost during rain via external data. |
| **SubscriptionPricing** | Returns zero delivery cost for premium members. |
| **PricingContext** | Executes the currently assigned pricing algorithm. |
| **PricingSelector** | Automatically selects a specific pricing algorithm for the current order. |
| **NearestCourierStrategy** | Assigns the geographically closest driver to the order. |
| **TopRatedStrategy** | Assigns a five-star driver to premium customers. |
| **BatchedStrategy** | Assigns a driver heading to the exact same destination area. |
| **AssignmentContext** | Executes the currently assigned courier matching algorithm. |
| **AssignmentSelector** | Automatically chooses a courier matching algorithm for the situation. |
| **SimulatedWeatherService** | Provides isolated external weather data for pricing algorithms. |

## 2. UML Class Diagram

```mermaid
classDiagram
    %% Domain Entities
    class Order {
        -double distanceKm
        -boolean customerHasSubscription
        +getDistanceKm() double
        +hasSubscription() boolean
    }
    class Customer {
        -boolean isVip
        +isVip() boolean
    }
    class Courier {
        -String name
        +getName() String
    }

    %% External Data Isolation
    class WeatherService {
        <<interface>>
        +isRaining() boolean
    }
    class SimulatedWeatherService {
        -boolean raining
        +setRaining(boolean)
        +isRaining() boolean
    }
    WeatherService <|.. SimulatedWeatherService

    %% Pricing Strategy (Family 1)
    class PricingStrategy {
        <<interface>>
        +calculatePrice(Order) double
    }
    class StandardPricing {
        +calculatePrice(Order) double
    }
    class SubscriptionPricing {
        +calculatePrice(Order) double
    }
    class SurgePricing {
        -WeatherService weatherService
        +calculatePrice(Order) double
    }
    PricingStrategy <|.. StandardPricing
    PricingStrategy <|.. SubscriptionPricing
    PricingStrategy <|.. SurgePricing
    SurgePricing --> WeatherService

    class PricingContext {
        -PricingStrategy strategy
        +setStrategy(PricingStrategy)
        +executePricing(Order) double
    }
    PricingContext o-- PricingStrategy : uses

    class PricingSelector {
        -WeatherService weatherService
        +selectStrategy(Order) PricingStrategy
    }
    PricingSelector --> WeatherService
    PricingSelector ..> PricingStrategy : creates

    %% Assignment Strategy (Family 2)
    class AssignmentStrategy {
        <<interface>>
        +assignCourier(Order) Courier
    }
    class NearestCourierStrategy {
        +assignCourier(Order) Courier
    }
    class TopRatedStrategy {
        +assignCourier(Order) Courier
    }
    class BatchedStrategy {
        +assignCourier(Order) Courier
    }
    AssignmentStrategy <|.. NearestCourierStrategy
    AssignmentStrategy <|.. TopRatedStrategy
    AssignmentStrategy <|.. BatchedStrategy

    class AssignmentContext {
        -AssignmentStrategy strategy
        +setStrategy(AssignmentStrategy)
        +executeAssignment(Order) Courier
    }
    AssignmentContext o-- AssignmentStrategy : uses

    class AssignmentSelector {
        +selectStrategy(Customer, boolean highDemand) AssignmentStrategy
    }
    AssignmentSelector ..> AssignmentStrategy : creates
3. Design Choice Justification
Why Strategy and not State?
The State pattern allows an object to alter its behavior when its internal state changes. In our domain, we are not tracking a life cycle. We simply need to execute a completely different mathematical calculation depending on external factors. Strategy is exactly designed to select an interchangeable algorithm at runtime without state transitions.

Why Strategy and not Template Method?
The Template Method pattern defines the skeleton of an algorithm in a base class, letting subclasses override specific steps. This relies heavily on inheritance. Our application requires completely swapping the entire logic. Strategy uses composition instead of inheritance, allowing the Context to swap the entire algorithm dynamically.
