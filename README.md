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

## 2. Design Choice Justification

**Why Strategy and not State?**
The State pattern allows an object to alter its behavior when its internal state changes (e.g., an Order moving from "Pending" to "Delivered"). In our domain, we are not tracking a life cycle. We simply need to execute a completely different mathematical calculation (pricing) depending on external factors. Strategy is exactly designed to select an interchangeable algorithm at runtime without state transitions.

**Why Strategy and not Template Method?**
The Template Method pattern defines the skeleton of an algorithm in a base class, letting subclasses override specific steps. This relies heavily on inheritance. Our application requires completely swapping the entire logic (e.g., standard math vs. zero cost vs. multiplier). Strategy uses composition instead of inheritance, allowing the Context to swap the entire algorithm dynamically without being locked into a rigid class hierarchy. 

## 3. Git Refactoring History
* **Before Refactoring (Bad Code):** [Вставь_ссылку_на_коммит_в_GitHub]
* **After Refactoring (Strategy):** [Вставь_ссылку_на_второй_коммит_в_GitHub]
