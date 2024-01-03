package com.aaron.observerpattern.model;

import com.aaron.observerpattern.display.DisplayObserver;

public interface WeatherSubject {
    void registerObserver(DisplayObserver observer);
    void removeObserver(DisplayObserver observer);
    void notifyObservers();
}
