package com.aaron.observerpattern.display;

import com.aaron.observerpattern.model.WeatherData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StatisticsDisplay implements WeatherObserver, WeatherDisplay {

    private final WeatherData weatherData;
    private Float maxTemp;
    private Float minTemp;
    private List<Float> temps = new ArrayList<>();
    private Float avgTemp;

    public StatisticsDisplay (WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
       if (maxTemp == null) maxTemp = temp;
       if (minTemp == null) minTemp = temp;
       if (temp > maxTemp) maxTemp = temp;
       if (temp < minTemp) minTemp = temp;
       temps.addAll(Arrays.asList(minTemp, minTemp, temp));
       OptionalDouble average = temps.stream().mapToDouble(t->t).average();
       float result = average.isPresent() ? (float) average.getAsDouble() : (float) 0.0;
       DecimalFormat df = new DecimalFormat("#.#");
       this.avgTemp = Float.valueOf(df.format(result));
       display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + avgTemp + "/" + maxTemp + "/" + minTemp);
    }
}
