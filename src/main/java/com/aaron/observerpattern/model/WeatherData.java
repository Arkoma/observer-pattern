package com.aaron.observerpattern.model;

import com.aaron.observerpattern.display.WeatherObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements  WeatherSubject {

    private float temperature;


    private float humidity;

    private float pressure;

    private final List<WeatherObserver> observers;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.notifyObservers();
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
    public void registerObserver(WeatherObserver observer) {
        // todo: add check if observer already exists
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(getTemperature(), getHumidity(), getPressure()));
    }

}
