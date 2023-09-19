package com.aaron.observerpattern.model;

import com.aaron.observerpattern.display.CurrentConditionsDisplay;
import com.aaron.observerpattern.display.ForecastDisplay;
import com.aaron.observerpattern.display.StatisticsDisplay;
import org.springframework.stereotype.Component;

@Component
public class WeatherData {

    private float temperature;

    private float humidity;

    private float pressure;

    private final CurrentConditionsDisplay currentConditionsDisplay;

    private final StatisticsDisplay statisticsDisplay;

    private final ForecastDisplay forecastDisplay;

    WeatherData(CurrentConditionsDisplay currentConditionsDisplay, StatisticsDisplay statisticsDisplay, ForecastDisplay forecastDisplay) {
        this.currentConditionsDisplay = currentConditionsDisplay;
        this.statisticsDisplay = statisticsDisplay;
        this.forecastDisplay = forecastDisplay;
    }

    public void measurementsChanged() {
        float temp = getTemperature();
        float humidity = getHumidity();
        float pressure = getPressure();

        currentConditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
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
}
