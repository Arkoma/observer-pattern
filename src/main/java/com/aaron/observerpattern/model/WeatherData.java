package com.aaron.observerpattern.model;

public class WeatherData {

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    private String temperature;

    private String humidity;

    private String pressure;

    public void measurementsChanged() {}
}
