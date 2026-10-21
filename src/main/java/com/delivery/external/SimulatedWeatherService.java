package com.delivery.external;

public class SimulatedWeatherService implements WeatherService {
    private boolean raining = false;
    public void setRaining(boolean raining) { this.raining = raining; }
    @Override
    public boolean isRaining() { return raining; }
}