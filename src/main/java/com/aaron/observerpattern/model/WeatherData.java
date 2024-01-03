package com.aaron.observerpattern.model;

import com.aaron.observerpattern.display.CurrentConditionsDisplay;
import com.aaron.observerpattern.display.DisplayObserver;
import com.aaron.observerpattern.display.ForecastDisplay;
import com.aaron.observerpattern.display.StatisticsDisplay;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements  WeatherSubject {

    private float temperature;


    private float humidity;

    private float pressure;

    private final List<DisplayObserver> observers = new ArrayList<>();

    public WeatherData() {}

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setTemperature(float temperature) {
        if (this.temperature != temperature) {
            this.temperature = temperature;
            this.notifyObservers();
        }
    }

    public void setHumidity(float humidity) {
        if (this.humidity != humidity) {
            this.humidity = humidity;
            this.notifyObservers();
        }
    }

    public void setPressure(float pressure) {
        if (this.pressure != pressure) {
            this.pressure = pressure;
            this.notifyObservers();
        }
    }

    @Override
    public void registerObserver(DisplayObserver observer) {
        // todo: add check if observer already exists
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(DisplayObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(getTemperature(), getHumidity(), getPressure()));
    }

}
