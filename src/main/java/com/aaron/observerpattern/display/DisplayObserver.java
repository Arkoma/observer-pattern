package com.aaron.observerpattern.display;

public interface DisplayObserver {
    void update(float temp, float humidity, float pressure);
}
