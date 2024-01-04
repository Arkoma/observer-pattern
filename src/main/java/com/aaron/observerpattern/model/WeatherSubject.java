package com.aaron.observerpattern.model;

import com.aaron.observerpattern.display.WeatherObserver;

public interface WeatherSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}
