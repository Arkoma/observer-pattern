package com.aaron.observerpattern.display;

import com.aaron.observerpattern.model.WeatherData;

public class ForecastDisplay implements WeatherObserver, WeatherDisplay {

    private final WeatherData weatherData;

    private String forecast;
    private float previousPressure = 0.0f;

    public ForecastDisplay (WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        String message = "";

        if (pressure > this.previousPressure) {
            message = "Improving weather on the way!";
        }
        if (pressure < this.previousPressure) {
            message = "Watch out for cooler, rainy weather";
        }
        if (pressure == this.previousPressure) {
            message = "More of the same";
        }

        this.forecast = message;

        display();

        this.previousPressure = pressure;
    }

    @Override
    public void display() {
        System.out.println(this.forecast);
    }
}
