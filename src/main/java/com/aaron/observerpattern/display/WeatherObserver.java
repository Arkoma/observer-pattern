package com.aaron.observerpattern.display;

public interface WeatherObserver {
    void update(float temp, float humidity, float pressure);
}
